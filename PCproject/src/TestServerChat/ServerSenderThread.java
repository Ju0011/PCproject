package TestServerChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerSenderThread extends Thread{
	Socket socket;
	  static String sendString;
	  
		public ServerSenderThread(Socket socket) {
			this.socket = socket;
		}

		@Override
	  public void run() {
	    try {
	      DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
	      
	      while(true){
	        sendString = "[관리자] : "+ServerGUI.ServerTxt();
	        sendWriter.writeUTF(sendString);
	        sendWriter.flush();
	      }
	    }catch (IOException e){
	    	System.out.println(e.getMessage());
	    }
	  }
	

}
