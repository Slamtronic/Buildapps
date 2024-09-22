import java.io.File;

public class JarMaker {
    public static void main(String[] args) {
        // Define the command to execute
        String[] command = {
            "jar", "cfm", "runnable.jar", "manifest.txt", "-C", "bin", "."
        };

        // Execute the command
        executeCommand(command);
    }

    private static void executeCommand(String[] command) {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(".")); // Set the working directory to current

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("JAR file created successfully.");
            } else {
                System.err.println("Error occurred while creating JAR file. Exit code: " + exitCode);
            }
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}