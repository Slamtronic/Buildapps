package sys;
import java.util.Scanner;

public class Sysio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        
        System.out.print("Enter your name: "); // Prompt the user for their name
        String name = scanner.nextLine(); // Read the input
        
		
        System.out.println("Hello, " + name + "!"); // Output the name
        
		System.out.print("Enter your age: ");
		int age = scanner.nextInt(); // Read the input
        System.out.println("u have, " + age + "year old!");
		 
        scanner.close(); // Close the scanner
    }
}