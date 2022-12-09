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
import javax.swing.JPanel;

public class Order extends JFrame implements ActionListener{
	
	JPanel Panel = new JPanel();
	JPanel southPanel = new JPanel();
	JButton button = new JButton("주문 하기");
	JButton[] food = new JButton[12];
	int price[] = { 3000, 2500, 2000, 3000, 3000, 3000, 3000, 3000, 3500, 1000,1000,2000 };
	String name[] = { "신라면", "진라면", "진라면(순한맛)", "너구리", "오징어 짬뽕", "비빔면", "짜파게티", "불닭", "참깨라면", "스프라이트","콜라","아메리카노" };
	TextField txtPrice[] = new TextField[name.length];
	int total[] = new int[food.length];
	Button minus[] = new Button[food.length];
    Button plus[] = new Button[food.length];
    
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
	
	int count = 0;
	
	public Order() {
		setSize(1400, 800);
		setLocation(80, 20); // 패널 시작 지점
		setTitle("주문화면");
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		
		Panel.setPreferredSize(new Dimension(1400, 400));
		southPanel.setPreferredSize(new Dimension(1400, 100));

		
		
		
		//button.setBounds(700, 600, 250, 100);
        button.setFont(new Font("배달의민족 한나", Font.BOLD, 35));
        southPanel.add(button, BorderLayout.SOUTH);
		
		
        TextArea txtArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        txtArea.setText("\t\t\t상품명\t\t\t\t\t\t단가\t\t\t\t\t\t수량\t\t\t\t\t\t합계\n\n");
        txtArea.setBackground(Color.white);
        txtArea.setEditable(false);
        txtArea.setFont(font);
        
		Panel.setLayout(new GridLayout(3, 4, 5, 5));
		for (int i = 0; i < 12; i++) {
			food[i]=new JButton("<HTML><body><center>" + name[i] + "<br>" + price[i]+"</center></body></HTML>",images[i]);
			food[i].setVisible(true);
			Panel.add(food[i]);
			food[i].setPreferredSize(new Dimension(100, 100));
			food[i].setBackground(Color.WHITE);
			food[i].setFont(font);
			food[i].addActionListener(this);
			
			txtPrice[i] = new TextField();
            txtPrice[i].setBackground(Color.white);
            txtPrice[i].setEditable(false);
            //txtPrice[i].setBounds(txtArea.getX(), txtArea.getY() + 130, 40, 20);
			
         // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(food[i].getX(), txtPrice[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(food[i].getX() + (100 - 20), txtPrice[i].getY(), 20, 20);
            plus[i].setEnabled(false);
            
		}
		
		
		
		
		
        for (int i = 0; i < name.length; i++) {
        	int j = i;
        	food[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(name[j]);
                    total[j]++;
                }
            });
        	
        	minus[i].addActionListener(new ActionListener() {
        		 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        txtPrice[j].setText(count + "");
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
        }
        
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
		if(e.getSource() == food[0]) {
			
		}
		
	}


}
