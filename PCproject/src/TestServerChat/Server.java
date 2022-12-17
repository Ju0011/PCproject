package TestServerChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] args) throws IOException {
	    int port = 8879;
	    ServerSocket socketServer = new ServerSocket(port);
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
