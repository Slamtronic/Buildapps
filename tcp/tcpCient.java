package tcp.Client;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class tcpCient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "192.168.8.119";
        final int SERVER_PORT = 1234;

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
            System.out.println("Type your message (or 'exit' to quit):");

            while (true) {
                System.out.print("You: ");
                String userMessage = scanner.nextLine();

                if ("exit".equalsIgnoreCase(userMessage)) {
                    System.out.println("Closing connection...");
                    break;
                }

                // Send message to server
                out.println(userMessage);

                // Wait for server response
                String serverResponse = in.readLine();
                if (serverResponse == null) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server: " + serverResponse);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}