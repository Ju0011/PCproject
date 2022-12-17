package TestClientChat2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	
	private String receiveString;

	  public ReceiverThread(Socket socket) {
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
	    try {
	      DataInputStream input = new DataInputStream(socket.getInputStream());
	      while (true) {
	        receiveString = input.readUTF();
	        if (receiveString == null) {
	          System.out.println("상대방 연결이 종료되었습니다.");
	        } else {
	          System.out.println("A : " + receiveString);
	        }
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }
	
}
