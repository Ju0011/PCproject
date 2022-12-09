package ServerChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	
	ReceiverThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String str = reader.readLine();
				if(str == null) {
					break;
				}
				System.out.println("수식> " + str);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
