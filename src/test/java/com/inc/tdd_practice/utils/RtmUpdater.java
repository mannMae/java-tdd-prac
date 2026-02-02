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

        File reportDir = new File(REPORT_DIR);
        if (!reportDir.exists()) {
            System.err.println("Report directory not found. Please run tests first: ./mvnw test");
            System.exit(1);
        }

        Map<String, String> results = new HashMap<>();

        File[] xmlFiles = reportDir.listFiles((dir, name) -> name.endsWith(".xml"));
        if (xmlFiles == null || xmlFiles.length == 0) {
            System.out.println("No test report XML files found.");
            return;
        }

        for (File file : xmlFiles) {
            String content = Files.readString(file.toPath());

            // Regex to find testcase tags
            Pattern testcasePattern = Pattern.compile("<testcase([^>]*)>");
            Matcher testcaseMatcher = testcasePattern.matcher(content);

            while (testcaseMatcher.find()) {
                String attributes = testcaseMatcher.group(1);

                // Extract classname and name from attributes
                String classname = getAttribute(attributes, "classname");
                String methodname = getAttribute(attributes, "name");

                if (classname == null || methodname == null)
                    continue;

                String simpleClassName = classname.substring(classname.lastIndexOf('.') + 1);
                String fullName = simpleClassName + "." + methodname;

                String status = "✅ PASS";

                // Check for failures/errors in the SUITE
                if (content.contains("<failure") || content.contains("<error")) {
                    status = "❌ FAIL";
                }

                results.put(fullName, status);
            }
        }

        updateRtmFile(results);
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
            if (line.contains("|") && line.contains("REQ-")) {
                for (Map.Entry<String, String> entry : results.entrySet()) {
                    String method = entry.getKey(); // MoneyTest.testMultiplication
                    String status = entry.getValue();

                    if (line.contains("`" + method + "`")) {
                        // Replace the status column (assuming it's the last one)
                        // Regex: Replace content after the last pipe before the closing pipe
                        line = line.replaceAll("\\|\\s*[^|]+\\s*\\|$", "| " + status + " |");
                        updateCount++;
                        break;
                    }
                }
            }
            newLines.add(line);
        }

        Files.write(rtmPath, newLines);
        System.out.println("✅ RTM Updated: " + updateCount + " rows processed.");
    }
}