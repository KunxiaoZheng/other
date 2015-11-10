import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;

public class ServerThread extends Thread {
	protected DatagramSocket socket;
	protected DatagramPacket inPacket;
	protected DatagramPacket outPacket;

	public ServerThread(String name) throws SocketException {
		super(name);
		socket = new DatagramSocket(4445);
	}

	public void run() {
		while (true) {
			try {
				byte[] buf = new byte[256];
				inPacket = new DatagramPacket(buf, buf.length);
				socket.receive(inPacket);
				buf = check(inPacket.getData());
				outPacket = new DatagramPacket(buf, buf.length,
						inPacket.getAddress(), inPacket.getPort());
				socket.send(outPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public byte[] check(byte[] x) {
		String temp = new String(x);
		/*int number = Integer.parseInt(temp);
		System.out.print("Server int:");
		System.out.println(number);*/
		System.out.println("Server:" + temp);
		int value = Server.checkStack(1);
		temp = String.valueOf(value);
		return temp.getBytes();
	}

}
买入、卖出，cancel
价格（买入/卖出），订单号，股票名字，数量， symbol
用户住址，下的单子，单子状态，帐号，余额