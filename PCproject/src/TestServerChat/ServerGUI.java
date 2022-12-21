package TestServerChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener{
	JTextArea txtA = new JTextArea();	//채팅기록
	JTextField txtF = new JTextField(15);	//보낼 채팅 입력창
	JButton sendbtn = new JButton("전송");
	JButton close = new JButton("닫기");
	JPanel panel = new JPanel();
	ServerSenderThread serversend;
	
	static String Servertxt;
	
	public ServerGUI() throws IOException{
		setBounds(300, 300, 350, 300);
		setTitle("관리자 채팅창");
		add(txtA, BorderLayout.CENTER);
		
		sendbtn.addActionListener(this);
		close.addActionListener(this);
		
		panel.add(txtF);
		panel.add(sendbtn);
		panel.add(close);
			

		
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ServerSocket socketServer = new ServerSocket(1124);
		System.out.println("채팅 서버 가동중...");

		while (true) {
			Socket sock = socketServer.accept();
			System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
			ServerReceiverThread receiveThread = new ServerReceiverThread(sock);
			receiveThread.start();
			ServerSenderThread sendThread = new ServerSenderThread(sock);
			sendThread.start();

			String receive = ServerReceiverThread.ServeReceiveMSG();
			if (receive == null) {
				System.out.println("서버)상대방 연결이 종료되었습니다.");
			} else {
				txtA.append(receive);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close) {
			dispose();
		}
		else if(e.getSource() == sendbtn) {
			serversend.run();
			Servertxt = txtF.getText();
			txtA.append("[관리자] : " + txtF.getText() + "\n");
			txtF.setText("");
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		new ServerGUI();
	}

	public static String ServerTxt() {
		return Servertxt;
	}
	
	
}
