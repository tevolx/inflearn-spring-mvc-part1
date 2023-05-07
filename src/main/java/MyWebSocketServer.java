import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;


public class MyWebSocketServer extends WebSocketServer {
	public MyWebSocketServer(int port) throws UnknownHostException {
		super(new InetSocketAddress(port));
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("New connection from " + conn.getRemoteSocketAddress());
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("Connection closed by " + conn.getRemoteSocketAddress() + " with code " + code + " and reason " + reason);
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("Received message from " + conn.getRemoteSocketAddress() + ": " + message);
		conn.send("Echo: " + message);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		System.err.println("Error occurred on connection " + conn.getRemoteSocketAddress() + ": " + ex.getMessage());
	}

	@Override
	public void onStart() {

	}

	public static void main(String[] args) {
		try {
			int port = 8080;
			MyWebSocketServer server = new MyWebSocketServer(port);
			server.start();
			System.out.println("WebSocket server listening on port " + server.getPort());
		} catch (UnknownHostException ex) {
			System.err.println("Error: " + ex.getMessage());
		}
	}
}

