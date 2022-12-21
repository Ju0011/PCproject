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
	      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
	      String sendString;
	      while(true){
	        sendString =  scanner.nextLine();
	        sendWriter.writeUTF(sendString);
	        sendWriter.flush();
	      }
	    }catch (IOException e){
	      e.printStackTrace();
	    }

	  }

}
