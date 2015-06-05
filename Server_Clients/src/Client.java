import java.io.IOException;
import java.net.*;

public class Client {
	public static void main(String[] args) throws IOException {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress receiverAddress = InetAddress.getLocalHost();
		byte[] buf = String.valueOf(100).getBytes();

		DatagramPacket inPacket = new DatagramPacket(buf, buf.length,
				receiverAddress, 4445);
		clientSocket.send(inPacket);
		buf = new byte[256];
		DatagramPacket outPacket = new DatagramPacket(buf, buf.length);
		clientSocket.receive(outPacket);
		
		
		System.out.print("client:");
		System.out.println(outPacket.getData());
		System.out.println(new String(outPacket.getData()));
	}
}
