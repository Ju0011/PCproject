package TestClientChat2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener{
	String str;
	JTextField txt;	//문장 입력창
	JTextArea ta; //문장 출력될 창
	
	PrintWriter pw;
	
	JScrollPane scroll;	//스크롤 바
	
	JPanel panel = new JPanel();
	
	public Client() {
		txt = new JTextField();
		ta = new JTextArea();
		
		setTitle("Client");
		
		scroll = new JScrollPane(ta);	//스크롤바 연결
		panel.add(scroll, "Center");
		
		panel.add(txt, BorderLayout.SOUTH);	//문장 입력창 하단 설정
		txt.addActionListener(this);
		txt.requestFocus();	//입력받을 컴포넌트 강제 설정
		
		setBounds(200, 200, 500, 350);
		add(panel);
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
		
	    Socket sock = new Socket("192.168.0.107", 8264);
	    System.out.println("서버와 접속되었습니다.");
	    ReceiverThread receiveThread = new ReceiverThread(sock);
	    receiveThread.start();
	    SenderThread sendThead = new SenderThread(sock);
	    sendThead.start();
	  }

}
