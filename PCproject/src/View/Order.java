package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Order extends JFrame implements ActionListener{
	
	JPanel Panel = new JPanel();
	JPanel southPanel = new JPanel();
	JButton button1 = new JButton("결제");
	JButton button2 = new JButton("초기화");
	JButton button3 = new JButton("닫기");
	JButton[] food = new JButton[12];
	int price[] = { 3000, 2500, 2000, 3000, 3000, 3000, 3000, 3000, 3500, 1000,1000,2000 };
	String name[] = { "신라면", "진라면", "진라면(순한맛)", "너구리", "오징어 짬뽕", "비빔면", "짜파게티", "불닭", "참깨라면", "스프라이트","콜라","아메리카노" };	
	int[] count = new int[food.length];
	
	ImageIcon[] images = { 
			   new ImageIcon("src/img/sin.jpg"), 
			   new ImageIcon("src/img/jin.jpg"), 
			   new ImageIcon("src/img/jinSun.jpg"), 
			   new ImageIcon("src/img/nu.jpg"),
			   new ImageIcon("src/img/oj.jpg"),
			   new ImageIcon("src/img/bi.jpg"),
			   new ImageIcon("src/img/zza.jpg"),
			   new ImageIcon("src/img/bul.jpg"),
			   new ImageIcon("src/img/cham.jpg"),
			   new ImageIcon("src/img/sprite.jpg"),
			   new ImageIcon("src/img/coke.jpg"),		   
			   new ImageIcon("src/img/iceA.jpg"),
			 };
	
	int sum = 0;
	public Order() {
		
		
		
		setSize(1400, 800);
		setLocation(80, 20); // 패널 시작 지점
		setTitle("주문화면");
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		Font BtnFont = new Font("배달의민족 한나", Font.BOLD, 35);
		
		Panel.setPreferredSize(new Dimension(1400, 400));
		southPanel.setPreferredSize(new Dimension(1400, 100));
	
		//button.setBounds(700, 600, 250, 100);
        button1.setFont(BtnFont);
        button2.setFont(BtnFont);
        button3.setFont(BtnFont);
        southPanel.add(button1, BorderLayout.SOUTH);
        southPanel.add(button2, BorderLayout.SOUTH);
        southPanel.add(button3, BorderLayout.SOUTH);
		
		//(String text, int row, int col, int scrollbar)
        TextArea txtArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        txtArea.setText("\t\t\t상품명\t\t\t\t\t\t단가\t\t\t\t\t\t수량\t\t\t\t\t\t합계\n");
        txtArea.setBackground(Color.white);
        txtArea.setEditable(false);	//편집 불가능
        txtArea.setFont(BtnFont);
        
		Panel.setLayout(new GridLayout(3, 4, 5, 5));
		for (int i = 0; i < 12; i++) {
			food[i]=new JButton("<HTML><body><center>" + name[i] + "<br>" + price[i]+"</center></body></HTML>",images[i]);
			food[i].setVisible(true);
			Panel.add(food[i]);
			food[i].setPreferredSize(new Dimension(100, 100));
			food[i].setBackground(Color.WHITE);
			food[i].setFont(font);
			food[i].addActionListener(this);            
           
		}
			
        //음식 버튼
        for (int i = 0; i < name.length; i++) {
        	int j = i;
        	
        	food[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    count[j]++;                
                    txtArea.append("\t\t" + name[j] + "\t\t\t\t\t\t" + price[j] + "\t\t\t\t\t\t" + count[j] + "\t\t\t\t\t\t" + price[j] * count[j]
                            + "원" + "\n");
                }
            });
        	sum += price[i] * count[i];
        }
        
     // 결제버튼
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, " 주문 완료되었습니다. \n이용해주셔서 감사합니다.", "주문 완료", JOptionPane.INFORMATION_MESSAGE);           	 
                
                for (int i = 0; i < food.length; i++) {
                    food[i].setEnabled(true);                                      
                    txtArea.setText("\t\t\t상품명\t\t\t\t\t\t단가\t\t\t\t\t\t수량\t\t\t\t\t\t합계\n");                   
                }
            }
        });
        
     // 초기화 버튼
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < food.length; i++) {
                    food[i].setEnabled(true);                                     
                    txtArea.setText("\t\t\t상품명\t\t\t\t\t\t단가\t\t\t\t\t\t수량\t\t\t\t\t\t합계\n");
 
                }
            }
        });
       
        //닫기버튼    
        button3.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
		
		
        
        add(Panel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(txtArea, BorderLayout.CENTER);
        
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	public static void main(String[] args) {
		new Order();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
