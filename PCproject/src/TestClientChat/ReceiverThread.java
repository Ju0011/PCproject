package TestClientChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket socket;
	
	private static String receiveString;

	  public ReceiverThread(Socket socket) {
	    this.socket = socket;
	  }

	  @Override
	  public void run() {
			try {
				DataInputStream tmpbuf = new DataInputStream(socket.getInputStream());
				while (true) {
					receiveString = tmpbuf.readUTF();
					if (receiveString == null) {
						receiveString = "상대방 연결이 종료되었습니다.";
					} else {
						System.out.println("상대방 : " + receiveString);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public static String ClinetReceiveMSG() {
			return receiveString;
		}

	}
