package TestServerChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ServerFrame extends JFrame implements ActionListener{
	JButton sendbtn;
	JTextArea txtA;
	JTextField txtF;
	

	static ServerSocket serverSocket = null;
	static Socket clientSocket =null;
	static PrintWriter out;
	static BufferedReader in;
	static String inputLine, outputLine;	
		
	public ServerFrame(){
		setSize(400, 500);
		setTitle("관리자 서버");
		
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
		String s;
		s="관리자 : "+txtF.getText(); 
		if(arg0.getSource() == sendbtn){
			txtA.append(s+"\n");
			out.println(s);
			txtF.setText("");
		}
		
	}
	
	public  void serverStart() throws IOException{
		try{
			serverSocket = new ServerSocket(1712);
		}catch(IOException e){
			System.exit(1);
		}
		
		clientSocket = null;
		try{
			clientSocket = serverSocket.accept();
		}catch(IOException e){
			System.exit(1);
		}
		
		out = new PrintWriter(clientSocket.getOutputStream(),true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		

		while((inputLine = in.readLine())!=null){
			String s =inputLine+"\n";
			System.out.println(s);
			txtA.append(s);
		}
	}
}
public class ServerTest {

	public static void main(String[] args) throws IOException {
		ServerFrame server = new ServerFrame();
		server.serverStart();
	}

}