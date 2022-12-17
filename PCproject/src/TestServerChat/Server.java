package TestServerChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] args) throws IOException {
	    ServerSocket socketServer = new ServerSocket(8824);
	    System.out.println("ss>>>" + socketServer);
        System.out.println("채팅 서버 가동중...");

	    while(true) {
	    	
	      Socket sock = socketServer.accept();
	      System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
	      ReceiverThread receiveThread = new ReceiverThread(sock);
	      receiveThread.start();
	      SenderThread sendThead = new SenderThread(sock);
	      sendThead.start();
	    }
	  }
}
