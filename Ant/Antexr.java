package ant;

import java.io.File;
import java.io.IOException;

public class Antexr {
    public static void main(String[] args) {
        try {
        	String antpath="C:/apache-ant-1.10.0/bin/ant.bat";
            // Command to execute Ant
            ProcessBuilder processBuilder = new ProcessBuilder(antpath,"-f","build.xml", "echo");
            processBuilder.directory(new File(".")); // Set working directory to current directory

            // Start the Ant process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Check the exit code
            if (exitCode == 0) {
                System.out.println("Ant build executed successfully.");
            } else {
                System.out.println("Ant build failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}