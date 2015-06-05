import java.net.SocketException;


public class Server {
	public static void main(String [] args) throws SocketException{
		new ServerThread("a").start();
	}
	public static int checkStack(int num){
		return 1;
	}
}
