package TestServerChat2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ReceiverThread extends Thread{
	Socket socket;

	  public ReceiverThread(Socket socket) {
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
	    try {
	      DataInputStream stream = new DataInputStream(socket.getInputStream());
	      String receiveString;
	      while (true) {
	        receiveString = stream.readUTF();
	        System.out.println("B : " + receiveString);
	      }
	    } catch (SocketException e1) {
	      System.out.println("상대방 연결이 종료되었습니다.");
	    } catch (IOException e2) {
	      e2.printStackTrace();
	    }
	  }
	
}
