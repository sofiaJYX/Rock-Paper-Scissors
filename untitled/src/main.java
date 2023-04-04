import java.io.*;
import java.net.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Client <server_ip> <port>");
            System.exit(1);
        }

        String serverIP = args[0];
        int port = Integer.parseInt(args[1]);

        try (
                Socket socket = new Socket(serverIP, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter ROCK, PAPER or SCISSORS (or QUIT to exit): ");
                String userInput = scanner.nextLine().toUpperCase();

                if (userInput.equals("QUIT")) {
                    break;
                } else if (!userInput.equals("ROCK") && !userInput.equals("PAPER") && !userInput.equals("SCISSORS")) {
                    System.out.println("Invalid input, please try again.");
                    continue;
                }

                out.println(userInput);
                String response = in.readLine();
                System.out.println("Received: " + response);
            }
        }
    }
}