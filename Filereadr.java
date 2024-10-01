package fil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Filereadr {
    public static void main(String[] args) {
        Path filePath = Paths.get("file.txt"); // Specify the path to your file

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(filePath);
            
            // Print each line
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IO exceptions
        }
    }
}
