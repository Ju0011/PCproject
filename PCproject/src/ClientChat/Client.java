package ClientChat;

import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.32", 9005);
			System.out.println("서버와 접속되었습니다.");
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
