package TestClientChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import View.SeatBtn;

class ClientFrame extends JFrame implements ActionListener {
	JButton sendbtn;
	JTextArea txtA;
	JTextField txtF;

	static PrintWriter out = null;
	static BufferedReader in = null;

	public ClientFrame() {
		setSize(400, 500);
		setTitle("클라이언트 채팅");
	
		JPanel panel = new JPanel();
	
		txtA = new JTextArea(30, 30);
		txtF = new JTextField(30);
		sendbtn = new JButton("입력");
		sendbtn.addActionListener(this);

		add(txtA);
		panel.add(txtF);
		panel.add(sendbtn);
		
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == sendbtn) {
			String s = ((SeatBtn.getseatN() + 1) + "번 자리 : " + txtF.getText());
			txtA.append(s+"\n");
			out.println(s);
			txtF.setText("");
		}
	}

	public void client() throws IOException {
		Socket socket = null;

		try {
			socket = new Socket("192.168.0.32", 1712);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			
		} catch (IOException e) {
			System.exit(1);
		}
		
		String fromServer;
		

		while ((fromServer = in.readLine()) != null) {
			
			String s =fromServer+"\n";
			txtA.append(s);
		}

		out.close();
		in.close();
		socket.close();
	}

}

public class ClientTest {

	public static void main(String[] args) throws IOException {
		ClientFrame Cf = new ClientFrame();
		Cf.client();

	}

}
