package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadTCPEchoServer {
	public final static int DEFAULT_PORT = 5000;

	public static void main(String[] args) {
		try(ServerSocket servSocket = new ServerSocket(DEFAULT_PORT)){
			while(true){
				Socket s = servSocket.accept();
				Runnable t = new TCPEchoThread(s);
				System.out.println("Accepted client:" +  s.getInetAddress()+" : "+s.getPort());
				new Thread(t).start();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

}
