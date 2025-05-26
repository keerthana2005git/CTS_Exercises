import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String userMsg, response;

            while (true) {
                System.out.print("Client: ");
                userMsg = consoleInput.readLine();
                output.println(userMsg);

                if (userMsg.equalsIgnoreCase("exit")) break;

                response = input.readLine();
                System.out.println("Server: " + response);
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

