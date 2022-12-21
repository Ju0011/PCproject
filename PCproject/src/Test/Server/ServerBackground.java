package Test.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private ServerGui gui;
	private String msg;

	/*사용자들의 정보를 저장하는 맵 */
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();

	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}

	public void setting() throws IOException {
			Collections.synchronizedMap(clientsMap);
			serverSocket = new ServerSocket(7718);
			while (true) {
				System.out.println("서버 대기중...");
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
				Receiver receiver = new Receiver(socket);
				receiver.start();
			}
	}

	public static void main(String[] args) throws IOException {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

	// 맵의내용(클라이언트) 저장과 삭제
	public void addClient(String outname, DataOutputStream out) throws IOException {
		sendMessage(outname + "님이 접속하셨습니다.");
		clientsMap.put(outname, out);
	}

	public void removeClient(String outname) {
		sendMessage(outname + "님이 나가셨습니다.");
		clientsMap.remove(outname);
	}

	// send
	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				clientsMap.get(key).writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// receive
	class Receiver extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private String outname;

		public Receiver(Socket socket) throws IOException {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			outname = in.readUTF();
			addClient(outname, out);
		}

		public void run() {
			try {
				while (in != null) {
					msg = in.readUTF();
					sendMessage(msg);
					gui.ServerAppendMsg(msg);
				}
			} catch (IOException e) {
				removeClient(outname);
			}
		}
	}
}
