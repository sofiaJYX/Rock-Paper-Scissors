import java.io.*;
import java.net.*;
import java.util.Random;

//this game server is created to listen for connections from clients and interact with them
public class Server {

    /**
     * This method is used to check the result of the game.
     *
     * @param player1Choice Player 1's turn.
     * @param player2Choice Player 2's turn.
     * @return A string representing the game result.
     */
    public static String gameResult(String p1Turn, String p2Turn) {
        if (p1Turn.equals(p2Turn)) {
            return "TIE";
        } else if (
                (p1Turn.equals("ROCK") && p2Turn.equals("SCISSORS")) ||
                        (p1Turn.equals("SCISSORS") && p2Turn.equals("PAPER")) ||
                        (p1Turn.equals("PAPER") && p2Turn.equals("ROCK"))
        ) {
            return "P1_WIN";
        } else {
            return "P2_WIN";
        }
    }

    public static void main(String[] args) throws IOException {
        // Check if it is the correct number
        if (args.length != 1) {
            System.err.println("Usage: java Server <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server listening on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Randomly select an option for the server
                String[] choices = {"ROCK", "PAPER", "SCISSORS"};
                String player2Choice = choices[new Random().nextInt(choices.length)];

                String result = gameResult(inputLine, player2Choice);
                String message = "Player1: " + inputLine + ", Player2: " + player2Choice + ", Result: " + result;
                out.println(message);
            }

    }
}