import java.io.IOException;
import java.net.ServerSocket;

public class FindAvailablePort {
    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(0)) {
            int port = socket.getLocalPort();
            System.out.println("Available port number: " + port);
        } catch (IOException e) {
            System.err.println("Error finding an available port number");
            e.printStackTrace();
        }
    }
}