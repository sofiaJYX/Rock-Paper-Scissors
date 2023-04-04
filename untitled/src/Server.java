import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {

    public static String gameResult(String player1Choice, String player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return "TIE";
        } else if (
                (player1Choice.equals("ROCK") && player2Choice.equals("SCISSORS")) ||
                        (player1Choice.equals("SCISSORS") && player2Choice.equals("PAPER")) ||
                        (player1Choice.equals("PAPER") && player2Choice.equals("ROCK"))
        ) {
            return "PLAYER1_WINS";
        } else {
            return "PLAYER2_WINS";
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Server <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] choices = {"ROCK", "PAPER", "SCISSORS"};
                String player2Choice = choices[new Random().nextInt(choices.length)];

                String result = gameResult(inputLine, player2Choice);
                String message = "Player1: " + inputLine + ", Player2: " + player2Choice + ", Result: " + result;
                out.println(message);
            }
        }
    }
}