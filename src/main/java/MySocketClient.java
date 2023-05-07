import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class MySocketClient {
	public static void main(String[] args) {
		String serverName = "localhost";
		int port = 8080;
		try {
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket clientSocket = new Socket(serverName, port);
			System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("Hello from client!");

			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("Server says: " + in.readUTF());

			clientSocket.close();
		} catch (IOException ex) {
			System.err.println("Error occurred: " + ex.getMessage());
		}
	}
}
