package use;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Userio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        int number = 0; // Variable to store the integer input
        boolean validInput = false; // Flag to track the validity of input

        while (!validInput) { // Loop until valid input is received
            System.out.print("Enter an integer: "); // Prompt the user for an integer
            
            try {
                number = scanner.nextInt(); // Attempt to read an integer
                validInput = true; // If successful, set flag to true
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("You entered: " + number); // Output the valid integer
        
        scanner.close(); // Close the scanner
    }
}