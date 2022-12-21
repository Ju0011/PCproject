package Test2Server;

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
	    	System.out.println("서버 받는 서버");
	      DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());	// 소켓 내용 읽어오기
	      while (true) {
	        receiveString = tmpbuf.readUTF();	 // 소켓 내용의 문자열을 readUTF 이용하여 읽기
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