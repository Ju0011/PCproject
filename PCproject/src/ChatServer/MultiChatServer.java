package ChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

//서버 -> 클라이언트 /-> 프레임

//클라이언트로 부터 전송된 문자열을 받아서 다른 클라이언트에게 문자열을 보내주는 스레드
class ServerThread extends Thread {

	Socket socket;
	Vector<Socket> vec;

	public ServerThread(Socket socket, Vector<Socket> vec) {
		this.socket = socket;
		this.vec = vec;
	}

	public void run() {
		BufferedReader br = null;	//Scanner
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = null;
			while (true) {

				// 클라이언트로 부터 문자열 받기
				str = br.readLine();

				// 상대가 접속을 끊으면 break;
				if (str == null) {
					// 벡터에서 없애기
					vec.remove(socket);					
					break;
				}

				// 연결된 소켓들을 통해서 클라이언트에게 문자열 보내주기
				sendMsg(str);
			}

		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (socket != null)
					socket.close();
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}

	// 전송받은 문자열 클라이언트에게 보내주는 메서드
	public void sendMsg(String str) {
		try {
			for (Socket socket : vec) {			
				if (socket != this.socket) { // for를 돌면서 현재의 socket이 데이터를 보낸 클라이언트인 경우를 제외하고 나머지 socket들에게 데이터를 보낸다.
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
					pw.println(str);	//문자열 출력
					pw.flush();		//현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
				}
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}

public class MultiChatServer {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		
		// 클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터객체 생성
		Vector<Socket> vec = new Vector<Socket>();

		try {
			server = new ServerSocket(4010);
			while (true) {
				System.out.println("접속대기중..");
				socket = server.accept();
				
				// 클라이언트와 연결된 소켓을 벡터에 담기
				vec.add(socket);

				// 스레드 시작
				new ServerThread(socket, vec).start();
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
