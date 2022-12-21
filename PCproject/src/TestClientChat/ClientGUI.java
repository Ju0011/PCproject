package TestClientChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import TestServerChat.ServerReceiverThread;
import View.SeatBtn;

public class ClientGUI extends JFrame implements ActionListener{
	JTextArea txtA = new JTextArea();	//채팅기록
	JTextField txtF = new JTextField(15);	//보낼 채팅 입력창
	JButton sendbtn = new JButton("전송");
	JButton close = new JButton("닫기");
	JPanel panel = new JPanel();
	
	SenderThread senderthread;
	
	static String txt;
	
	public ClientGUI() throws IOException{
		setBounds(300, 300, 350, 300);
		setTitle(SeatBtn.getseatN() + 1 + " 번 자리 채팅창");
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
		
		
		
		Socket sock = new Socket("192.168.0.32", 1124);
		System.out.println("서버와 접속되었습니다.");
	    ReceiverThread receiveThread = new ReceiverThread(sock);
	    receiveThread.start();
	    SenderThread sendThead = new SenderThread(sock);
	    sendThead.start();
	    
		String receive = ReceiverThread.ClinetReceiveMSG();
		if (receive == null) {
			System.out.println("클라이언트)상대방 연결이 종료되었습니다.");
		} else {
			txtA.append(receive);
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == close) {
			dispose();
		} else if (e.getSource() == sendbtn) {
			senderthread.run();
			txt = txtF.getText();
			txtA.append("[" + (SeatBtn.getseatN() + 1) + " 번] : " + txtF.getText() + "\n");
			txtF.setText("");
			
		}
	}

	public static void main(String[] args) throws IOException {
		new ClientGUI();
	}

	public static String txt() {
		return txt;
	}

}
