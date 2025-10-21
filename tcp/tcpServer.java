package tcp.server;
import java.io.*;
import java.net.*;

public class tcpServer {
    public static void main(String[] args) {
        final int PORT = 1234;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client connection on port " + PORT + "...");

            // Wait for client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Create I/O streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String receivedMessage;
            while ((receivedMessage = in.readLine()) != null) {
                System.out.println("Received from client: " + receivedMessage);
                out.println("OK"); // Send response
            }

            System.out.println("Client disconnected.");
            clientSocket.close();

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}