package Test2Client;

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
	      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
	      while (true) {
	    	 System.out.println("클라이언트 받는 서버");
	        receiveString = tmpbuf.readUTF();
	        if (receiveString == null) {
	          System.out.println("상대방 연결이 종료되었습니다.");
	        } else {
	          System.out.println("상대방 : " + receiveString);
	        }
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }

	  }
	
}