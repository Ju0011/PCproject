package TestClientChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SenderThread extends Thread{
	Socket socket;

	Scanner scanner = new Scanner(System.in);
	static String sendString;

	public SenderThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataOutputStream sendWriter = new DataOutputStream(socket.getOutputStream());

			while (true) {
				sendString = ClientGUI.txt();
				sendWriter.writeUTF(sendString); // UTF로 인코딩후 출력
				sendWriter.flush(); // 버퍼 비우기
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String sendMSG() {
		return sendString;
	}
}
