package TestServerChat2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener {
	
	String str;
	JTextField txt;	//문장 입력창
	JTextArea ta; //문장 출력될 창
	
	PrintWriter pw;
	
	JScrollPane scroll;	//스크롤 바
	
	public Server() {
		txt = new JTextField();
		ta = new JTextArea();

		setTitle("Server");
		
		scroll = new JScrollPane(ta);	//스크롤바 연결
		add(scroll, "Center");
		
		add(txt, BorderLayout.SOUTH);	//문장 입력창 하단 설정
		txt.addActionListener(this);
		txt.requestFocus();	//입력받을 컴포넌트 강제 설정
		
		setBounds(200, 200, 500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 내가 쓴 메세지를 str 변수에 저장
		str = txt.getText();

		// 변수에 저장 후 텍스트필드 초기화
		txt.setText("");

		// 내가 쓴 메세지 출력 -> 상대방은 br.readLine()으로 읽어들임
		pw.println(str);
		pw.flush();
	}
	
	public static void main(String[] args) throws IOException {
	    ServerSocket socketServer = new ServerSocket(8264);
	    System.out.println("ss>>>" + socketServer);
        System.out.println("채팅 서버 가동중...");

	    while(true) {
	    	
	      Socket sock = socketServer.accept();
	      System.out.println("ip : " + sock.getInetAddress() + " 와 연결되었습니다.");
	      ReceiverThread receiveThread = new ReceiverThread(sock);
	      receiveThread.start();
	      SenderThread sendThead = new SenderThread(sock);
	      sendThead.start();
	    }
	  }
}
