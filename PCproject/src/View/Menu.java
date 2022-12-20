package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ChatClient.ClientFrame;
import ChatClient.MultiChatClient;
import ChatServer.MultiChatServer;
import Login.Data;



public class Menu extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JPanel Northpanel = new JPanel();
	
	JButton orderbtn = new JButton("음식 주문");
	JButton chatbtn = new JButton("관리자 채팅");
	
	JLabel[] label = new JLabel[3];
	
	
	public Menu() {
		setSize(800, 600);
		setLocation(80, 20); // 패널 시작 지점
		setTitle("메뉴화면");
		
		Font font = new Font("SanSerif", Font.BOLD, 30);
				
		orderbtn.setFont(font);
		orderbtn.setBounds(120, 400, 200, 100);
		orderbtn.addActionListener(this);
		
		chatbtn.setFont(font);
		chatbtn.setBounds(480, 400, 200, 100);
		chatbtn.addActionListener(this);
		
		Northpanel.setLayout(null);
		Northpanel.setBackground(Color.white);
		Northpanel.setBounds(20, 20, 749, 300);

		int labelY = 20;
		for (int i = 0; i < label.length; i++) {
			if (i == 0)
				label[i] = new JLabel((SeatBtn.getseatN() + 1) + "번 자리");
			else if (i == 1) {
				if (Data.getID() == null)
					label[i] = new JLabel("사용자 아이디 : 비회원");
				else
					label[i] = new JLabel("사용자 아이디 : " + Data.getID());

			} else if (i == 2) {
				label[i] = new JLabel("잔여시간 : " + (Data.getTime()+Charge.getTime()) + " 분");
			} else {
				label[i] = new JLabel("");
			}

			label[i].setBounds(20, labelY, 749, 40);
			labelY += 50;
			label[i].setFont(font);
			Northpanel.add(label[i]);
		}
		

		panel.add(Northpanel);
		panel.setLayout(null);
		panel.add(orderbtn);
		panel.add(chatbtn);
		add(panel);
		
		setLocationRelativeTo(null);
		setVisible(true);	
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == orderbtn) {
			new Order();
		}
		else if(e.getSource() == chatbtn) {
			new MultiChatServer();
			new MultiChatClient();
			new ClientFrame(null);
			
		}
		
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}
