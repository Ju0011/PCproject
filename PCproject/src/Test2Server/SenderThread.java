package Test2Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread{
	Socket socket;
	
	Scanner scanner = new Scanner(System.in);

	  public SenderThread(Socket socket){
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
	    try {
	    System.out.println("서버 보내는 서버");
	      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());	//파일에 데이터 기록
	      String sendString;
	      while(true){
	        sendString =  scanner.nextLine();
	        sendWriter.writeUTF(sendString);	//sendString의 내용을 writeUTF 이용하여 문자열로 변환한 후 sendWriter에 담기
	        sendWriter.flush();	// 내용 전송 후 비워내기
	      }
	    }catch (IOException e){
	      e.printStackTrace();
	    }

	  }

}
