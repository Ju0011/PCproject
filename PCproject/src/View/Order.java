package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Order extends JFrame{
	
	JPanel Panel = new JPanel();
	JPanel southPanel = new JPanel();
	JButton button = new JButton("주문 하기");
	JButton[] food = new JButton[12];

	ImageIcon[] images = { 
			   new ImageIcon("src/img/sin.jpg"), 
			   new ImageIcon("src/img/jin.jpg"), 
			   new ImageIcon("src/img/jinSun.jpg"), 
			   new ImageIcon("src/img/nu.jpg"),
			   new ImageIcon("src/img/oj.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			   new ImageIcon("src/img/sin.jpg"),
			  
			 };
	
	public Order() {
		setSize(1400, 800);
		setLocation(80, 20); // 패널 시작 지점
		setTitle("주문화면");
		
		Panel.setPreferredSize(new Dimension(1400, 500));
		southPanel.setPreferredSize(new Dimension(1400, 300));

		
		add(Panel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		
		//button.setBounds(700, 600, 250, 100);
		
        button.setFont(new Font("배달의민족 한나", Font.BOLD, 35));
        southPanel.add(button);
		
		

		
		Panel.setLayout(new GridLayout(3, 4, 5, 5));
		for (int i = 0; i < 12; i++) {
			food[i]=new JButton(images[i]);
			food[i].setVisible(true);
			Panel.add(food[i]);
			food[i].setPreferredSize(new Dimension(100, 100));
			food[i].setBackground(Color.WHITE);
			
		}
		
		
		setLocationRelativeTo(null);

		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	public static void main(String[] args) {
		new Order();
	}

}
