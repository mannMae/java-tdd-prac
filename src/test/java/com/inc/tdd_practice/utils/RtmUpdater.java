package com.inc.tdd_practice.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class RtmUpdater {

    private static final String RTM_FILE = "docs/RTM.md";
    private static final String REPORT_DIR = "target/surefire-reports";

    public static void main(String[] args) throws IOException {
        System.out.println("🔍 Scanning test results in " + REPORT_DIR + "...");

        Map<String, String> results = scanTestReports();
        updateRtmFile(results);
    }

    private static Map<String, String> scanTestReports() throws IOException {
        Map<String, String> results = new HashMap<>();
        File reportDir = new File(REPORT_DIR);

        if (!reportDir.exists()) {
            System.err.println("⚠️ Report directory not found. Please run tests first: ./mvnw test");
            return results;
        }

        File[] xmlFiles = reportDir.listFiles((dir, name) -> name.endsWith(".xml"));
        if (xmlFiles == null || xmlFiles.length == 0) {
            System.out.println("No test report XML files found.");
            return results;
        }

        for (File file : xmlFiles) {
            String content = Files.readString(file.toPath());

            // Extract individual testcase blocks
            Pattern tcPattern = Pattern.compile("<testcase\\s+([^>]+)>(.*?)</testcase>", Pattern.DOTALL);
            Matcher tcMatcher = tcPattern.matcher(content);

            // Also check for empty testcase tags like <testcase ... />
            Pattern tcEmptyPattern = Pattern.compile("<testcase\\s+([^/>]+)/>");

            parseTestCases(tcMatcher, results, false);

            tcMatcher = tcEmptyPattern.matcher(content);
            parseTestCases(tcMatcher, results, true);
        }
        return results;
    }

    private static void parseTestCases(Matcher matcher, Map<String, String> results, boolean isEmptyTag) {
        while (matcher.find()) {
            String attributes = matcher.group(1);
            String classname = getAttribute(attributes, "classname");
            String methodname = getAttribute(attributes, "name");

            if (classname == null || methodname == null)
                continue;

            String simpleClassName = classname.substring(classname.lastIndexOf('.') + 1);
            String fullName = simpleClassName + "." + methodname;

            String status = "✅ PASS";

            if (!isEmptyTag) {
                String body = matcher.group(2);
                if (body.contains("<failure") || body.contains("<error")) {
                    status = "❌ FAIL";
                }
            } else {
                // For empty tags, we already know it didn't have immediate child failures in
                // the body
                // but some reporters might put failure as an attribute? (Usually not in JUnit
                // XML)
            }

            results.put(fullName, status);
        }
    }

    private static String getAttribute(String text, String key) {
        Pattern p = Pattern.compile(key + "=\"([^\"]*)\"");
        Matcher m = p.matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    private static void updateRtmFile(Map<String, String> results) throws IOException {
        Path rtmPath = Paths.get(RTM_FILE);
        if (!Files.exists(rtmPath)) {
            System.out.println(RTM_FILE + " not found.");
            return;
        }

        List<String> lines = Files.readAllLines(rtmPath);
        List<String> newLines = new ArrayList<>();
        int updateCount = 0;

        for (String line : lines) {
            String processedLine = line;
            if (line.contains("|") && line.contains("`")) {
                // Find all `TestClass.testMethod` patterns in the line
                Pattern testRefPattern = Pattern.compile("`([A-Za-z0-9_]+\\.[A-Za-z0-9_]+)`");
                Matcher matcher = testRefPattern.matcher(line);

                if (matcher.find()) {
                    String testName = matcher.group(1);
                    String status = results.getOrDefault(testName, "❓ NO_REPORT");

                    // Replace the status column (last valid column)
                    processedLine = line.replaceAll("\\|\\s*[^|]*\\s*\\|$", "| " + status + " |");
                    updateCount++;
                }
            }
            newLines.add(processedLine);
        }

        Files.write(rtmPath, newLines);
        System.out.println("✅ RTM Updated: " + updateCount + " rows processed.");
        if (results.isEmpty()) {
            System.out.println("💡 Note: No test results were found in current reports.");
        }
    }
}