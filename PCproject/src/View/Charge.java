package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Charge extends JFrame implements  ItemListener{
	JPanel panel = new JPanel();
	BufferedImage img = null;
	JButton button = new JButton("충전하기");
	
	JRadioButton rd1 = new JRadioButton("회원 요금");
    JRadioButton rd2 = new JRadioButton("비회원 요금");
	
	JButton m_b1 = new JButton("<HTML><body><center>1시간<br>(01:00)<br>1000원</center></body></HTML>");
	JButton m_b2 = new JButton("<HTML><body><center>2시간 20분<br>(02:20)<br>2000원</center></body></HTML>");
	JButton m_b3 = new JButton("<HTML><body><center>5시간 20분<br>(05:20)<br>3000원</center></body></HTML>");
	JButton m_b4 = new JButton("<HTML><body><center>11시간<br>(11:00)<br>10000원</center></body></HTML>");
	JButton m_b5 = new JButton("<HTML><body><center>35시간<br>(35:00)<br>30000원</center></body></HTML>");
	
	
	JButton b1 = new JButton("<HTML><body><center>1시간<br>(01:00)<br>1000원</center></body></HTML>");
	JButton b2 = new JButton("<HTML><body><center>2시간<br>(02:00)<br>2000원</center></body></HTML>");
	JButton b3 = new JButton("<HTML><body><center>5시간<br>(05:00)<br>5000원</center></body></HTML>");
	JButton b4 = new JButton("<HTML><body><center>11시간<br>(11:00)<br>11000원</center></body></HTML>");
	JButton b5 = new JButton("<HTML><body><center>35시간<br>(35:00)<br>35000원</center></body></HTML>");
	
	boolean check = true;
	
	public Charge(){
		
		setSize(1400, 800);
		setLocation(80, 20); //패널 시작 지점
		setTitle("요금창");
		setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0, 0, 1400, 800);
        
        
        Font font = new Font("배달의민족 한나", Font.BOLD, 30);	//라디오 버튼 폰트
        Font font_2 = new Font("배달의민족 한나", Font.BOLD, 20); //요금 버튼 폰트
        
        rd1.setBounds(200, 50, 200, 100);
        rd2.setBounds(500, 50, 200, 100);
        
        rd1.setFont(font);
        rd2.setFont(font);
        
        // 1번 라디오 버튼 눌러져있도록
        rd1.setSelected(true);
        
        // 라디오 버튼을 그룹화 
        ButtonGroup groupRd = new ButtonGroup();
        
        // 그룹에 라디오 버튼 포함
        groupRd.add(rd1);
        groupRd.add(rd2);

        rd1.addItemListener(this);
        rd2.addItemListener(this);
        
        panel.add(rd1);
        panel.add(rd2);
 
        button.setBounds(700, 600, 250, 100);
        button.setFont(new Font("배달의민족 한나", Font.BOLD, 35));
        panel.add(button);
        
       
        
        if(check) {
        	
    		m_b1.setBounds(200, 200, 150, 100);
            m_b1.setFont(font_2);
            panel.add(m_b1);
            
            m_b2.setBounds(200, 350, 150, 100);
            m_b2.setFont(font_2);
            panel.add(m_b2);
            
            m_b3.setBounds(200, 500, 150, 100);
            m_b3.setFont(font_2);
            panel.add(m_b3);
            
            m_b4.setBounds(500, 200, 150, 100);
            m_b4.setFont(font_2);
            panel.add(m_b4);
            
            m_b5.setBounds(500, 350, 150, 100);
            m_b5.setFont(font_2);
            panel.add(m_b5);
        }
        else {
        	b1.setBounds(200, 200, 150, 100);
            b1.setFont(font_2);
            panel.add(b1);
            
            b2.setBounds(200, 350, 150, 100);
            b2.setFont(font_2);
            panel.add(b2);
            
            b3.setBounds(200, 500, 150, 100);
            b3.setFont(font_2);
            panel.add(b3);
            
            b4.setBounds(500, 200, 150, 100);
            b4.setFont(font_2);
            panel.add(b4);
            
            b5.setBounds(500, 350, 150, 100);
            b5.setFont(font_2);
            panel.add(b5);
        }
        

        MyPanel img_panel = new MyPanel();
		img_panel.setLayout(null);
		img_panel.setBounds(990, 0, 400, 900);
		panel.add(img_panel);
        
		try {
			img = ImageIO.read(new File("src/img/charge.png"));
		} catch (IOException e) {
			System.out.println("이미지 불러오기 실패");
			System.exit(0);
		}
		
		
		add(panel);
		setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
                          
	}
	
	public class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
	}
	
	public static void main(String[] args) {
		new Charge();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == rd2){
			check = false;
		}
		
	}

}
