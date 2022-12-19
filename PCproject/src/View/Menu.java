package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Menu extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JButton orderbtn = new JButton("음식 주문");
	JButton chatbtn = new JButton("관리자 채팅");
	
	
	public Menu() {
		setSize(800, 600);
		setLocation(80, 20); // 패널 시작 지점
		setTitle("메뉴화면");
		
		Font font = new Font("SanSerif", Font.BOLD, 30);
		Font infofont = new Font("SanSerif", Font.BOLD, 10);
		
		//(String text, int row, int col, int scrollbar)
		TextArea txtArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        txtArea.setText("\t\t\t상품명\t\t\t\t\t\t단가\t\t\t\t\t\t수량\t\t\t\t\t\t합계\n");
        txtArea.setBackground(Color.white);
        txtArea.setEditable(false);	//편집 불가능
        txtArea.setFont(infofont);
        
        add(txtArea, BorderLayout.CENTER);
		
		orderbtn.setFont(font);
		orderbtn.setBounds(120, 400, 200, 100);
		orderbtn.addActionListener(this);
		
		chatbtn.setFont(font);
		chatbtn.setBounds(480, 400, 200, 100);
		chatbtn.addActionListener(this);
		
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
			dispose();
			new Order();
		}
		else if(e.getSource() == chatbtn) {
			
		}
		
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
	}
}
