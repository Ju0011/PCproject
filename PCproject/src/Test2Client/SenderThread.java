package Test2Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread{
	Socket socket;

	Scanner scanner = new Scanner(System.in);

	public SenderThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("클라이언트 보내는 서버");
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());
			String sendString;
			while (true) {
				sendString = scanner.nextLine();
				sendWriter.writeUTF(sendString);
				sendWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
