package TestClientChat;

import java.io.IOException;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
	    Socket sock = new Socket("192.168.0.32", 8879);
	    System.out.println("서버와 접속되었습니다.");
	    ReceiverThread receiveThread = new ReceiverThread(sock);
	    receiveThread.start();
	    SenderThread sendThead = new SenderThread(sock);
	    sendThead.start();
	  }

}
