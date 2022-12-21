package Test.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import View.SeatBtn;

public class ClientGui  extends JFrame implements ActionListener{

	private JTextArea txtA = new JTextArea(40, 25);
	private JTextField txtF = new JTextField(25);
	private ClientBackground client = new ClientBackground();
	private static String Name;
	
	public ClientGui() {
		
		add(txtA, BorderLayout.CENTER);
		add(txtF, BorderLayout.SOUTH);
		txtF.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle("클라이언트");
		
		client.setGui(this);
		client.setNickname(Name);
		client.connet();
	}
	
	public static void main(String[] args) {
		Name = ((SeatBtn.getseatN() + 1) + "번 자리");	
		new ClientGui();

	}

	@Override
	//send
	public void actionPerformed(ActionEvent e) {
		String msg = Name+ ":" + txtF.getText()+"\n";
		client.sendMessage(msg);
		txtF.setText("");
	}

	public void appendMsg(String msg) {
		txtA.append(msg);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
