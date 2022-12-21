package TestServerChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ServerReceiverThread extends Thread{
	Socket socket;
	private static String ServeReceive;
	
	  public ServerReceiverThread(Socket socket) {
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
	    try {
	      DataInputStream stream = new DataInputStream(socket.getInputStream());
	      
	      while (true) {
	        ServeReceive = stream.readUTF();
	        System.out.println("상대방 : " + ServeReceive);
	      }
	    } catch (SocketException e1) {
	      System.out.println("상대방 연결이 종료되었습니다.");
	    } catch (IOException e2) {
	      e2.printStackTrace();
	    }
	  }
	  public static String ServeReceiveMSG() {
			return ServeReceive;
		}
	
}
