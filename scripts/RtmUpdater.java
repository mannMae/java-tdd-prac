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

            // Regex to find testcase elements: <testcase ... classname="X" name="Y" ... >
            Pattern pattern = Pattern.compile("<testcase[^>]*classname=\"([^\"]*)\"[^>]*name=\"([^\"]*)\"[^>]*>");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String classname = matcher.group(1);
                String methodname = matcher.group(2);
                String simpleClassName = classname.substring(classname.lastIndexOf('.') + 1);
                String fullName = simpleClassName + "." + methodname;

                // Naive Failure/Error Detection logic usually valid for surefire xml
                // If the XML content contains failure/error tags, we should be careful.
                // Ideally we check if <failure> is nested inside the testcase, but Regex is
                // limited.
                // However, Surefire XML usually puts the failure message attribute inside the
                // failure tag which follows testcase.

                String status = "✅ PASS";
                // Broad check: If file contains failure/error, and we are in strict mode,
                // simpler to flag it.
                // Refined check: Look for the specific test name followed by failure in the
                // file content? Hard with simple regex.

                // Let's use the 'failures' and 'errors' attribute from testsuite tag for
                // file-level check
                // <testsuite ... failures="1" ...>
                if (content.contains("failures=\"0\"") && content.contains("errors=\"0\"")) {
                    status = "✅ PASS";
                } else {
                    // File has failures. Is it THIS test?
                    // Safe bet for now: If the SUITE fails, mark its methods as FAIL/CHECK
                    status = "❌ FAIL";
                }

                results.put(fullName, status);
            }
        }

        updateRtmFile(results);
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
                        // Regex: Replace content between last pair of pipes
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
