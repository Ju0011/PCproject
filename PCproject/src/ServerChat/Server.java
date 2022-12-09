package ServerChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener{
	private JTextArea jta = new JTextArea(40, 25);
    private JTextField jtf = new JTextField(25);
    
    
    public Server() {
    	add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200, 100, 400, 600);
        setTitle("서버부분");
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "서버 : "+ jtf.getText() + "\n";
        System.out.print(msg);
        jtf.setText("");
    }
 
    public void appendMsg(String msg) {
        jta.append(msg);
    }
    
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9001);
			socket = serverSocket.accept();
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				serverSocket.close();
			}catch(Exception ignored) {
				
			}
		}
	}
}
