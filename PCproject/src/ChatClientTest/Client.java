package ChatClientTest;

import java.net.*;

//입출력 클래스
import java.io.*;

//그래픽 관련 클래스
import java.awt.*; // GUI
import javax.swing.*; // JFrame, JTextField, JTextArea, JScrollPane

//Event 처리
import java.awt.event.*; // ActionListener

public class Client extends JFrame implements ActionListener, Runnable {

	
	JTextField tf; // 전송할 텍스트 입력창
	JTextArea ta; // 전송받은 텍스트 출력

	JScrollPane js; // 스크롤바 생성
	
	Socket s; // 서버와의 통신을 위함

	
	BufferedReader br; // 클라이언트에서의 문자열 입력 스트림
	PrintWriter pw; // 문자열 출력 스트림

	// 서버로 전송할 문자열과 서버에서 받아올 문자열 변수
	String str, str1;

	
	public Client() {
		
		tf = new JTextField();
		ta = new JTextArea();

		setTitle("Client");
		// 텍스트 출력창에 스크롤 바 연결
		js = new JScrollPane(ta);

		add(js, "Center");

		// 텍스트 필드를 하단에 부착
		add(tf, BorderLayout.SOUTH);

		// 이벤트
		tf.addActionListener(this);

		// 텍스트 필드에 커서 입력
		tf.requestFocus();

		setBounds(200, 200, 500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			//접속 서버 IP 주소, 서버 포트 번호
			s = new Socket("192.168.0.32", 4448);
			System.out.println("s>>>" + s);

			// ========== Server와 Stream 연결 ===========
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			// PrintWriter 스트림의 autoFlush 기능 활성화
			pw = new PrintWriter(s.getOutputStream(), true);

		} catch (Exception e) {
			System.out.println("접속 오류>>>" + e);
		}

		// Thread 객체 생성, Runnable 인터페이스를 구현하기 때문에 this 작성
		Thread ct = new Thread(this);

		// 클라이언트 스레드 실행 → run() 호출
		ct.start();
	}

	public void run() {
		try {
			while ((str1 = br.readLine()) != null) {
				ta.append(str1 + "\n"); // 상대방이 보낸 문자를 채팅창에 세로로 출력
			}
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
	}

	public void actionPerformed(ActionEvent e) {
		// 내가 쓴 메세지를 str 변수에 저장
		str = tf.getText();

		// 변수에 저장 후 텍스트필드 초기화
		tf.setText("");

		// 내가 쓴 메세지 출력 -> 상대방은 br.readLine()으로 읽어들임
		pw.println(str);
		pw.flush();
	}

	public static void main(String[] args) {		
		new Client();

	}

}
