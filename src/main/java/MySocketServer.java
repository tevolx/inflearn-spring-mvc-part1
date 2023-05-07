import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
	public static void main(String[] args) {
		int port = 8080;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Waiting for client on port" + serverSocket.getLocalPort() + "...");
			Socket server = serverSocket.accept();
			System.out.println("Connected to " + server.getRemoteSocketAddress());

			DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());

			String message = dataInputStream.readUTF();
			System.out.println("Client message : " + message);
			dataOutputStream.writeUTF("Message from server");

			server.close();
		} catch (IOException ex) {
			System.err.println("");
		}

	}
}
