package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Charge extends JFrame{
	JPanel panel = new JPanel();
	
	JPanel centerPanel = new JPanel();
	JPanel centerPanel_2 = new JPanel();
	
	BufferedImage img = null;
	JButton button = new JButton("충전하기");
	
	JRadioButton rd1 = new JRadioButton("회원 요금");
    JRadioButton rd2 = new JRadioButton("비회원 요금");
	
    JButton[] m_b = new JButton[5];
    JButton[] b = new JButton[5];
    
    String m_time[] = {"1시간", "2시간 20분", "5시간 20분", "11시간", "35시간"};
    String m_charge[] = {"1000원", "2000원", "3000원", "10000원", "30000원"};
    String m_fulltime[] = {"(01:00)", "(02:20)", "(05:20)", "(11:00)", "(35:00)"};
    
    String time[] = {"1시간", "2시간", "5시간", "11시간", "35시간"};
    String charge[] = {"1000원", "2000원", "5000원", "11000원", "35000원"};
    String fulltime[] = {"(01:00)", "(02:00)", "(05:00)", "(11:00)", "(35:00)"};   
   	
	int x = 200, y = 200;
	
	public Charge(){
		
		setSize(1400, 800);
		setLocation(80, 20); //패널 시작 지점
		setTitle("요금창");
		setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0, 0, 1400, 800);
        
        
        Font font = new Font("SanSerif", Font.BOLD, 30);	//라디오 버튼 폰트
        Font font_2 = new Font("SanSerif", Font.BOLD, 20); //요금 버튼 폰트
        
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

        panel.add(rd1);
        panel.add(rd2);
 
        button.setBounds(700, 600, 250, 100);
        button.setFont(new Font("배달의민족 한나", Font.BOLD, 35));
        panel.add(button);
        
        for (int i = 0; i < m_b.length; i++) {
        	m_b[i]=new JButton("<HTML><body><center>" + m_time[i] + "<br>" + m_fulltime[i]+ "<br>"+m_charge[i]+"</center></body></HTML>");
        	m_b[i].setVisible(true);
        	m_b[i].setFont(font_2);
    		centerPanel.add(m_b[i]);
    		
    		b[i]=new JButton("<HTML><body><center>" + time[i] + "<br>" + fulltime[i]+ "<br>"+charge[i]+"</center></body></HTML>");
        	b[i].setVisible(true);
        	b[i].setFont(font_2);
    		centerPanel_2.add(b[i]);
    		
        	if (y > 500) {
				y = 200;
				x += 300;
			}
        	
        	m_b[i].setBounds(x, y, 150, 100);
        	b[i].setBounds(x, y, 150, 100);
        	y += 150;
         }
		
		centerPanel.setLayout(null);
		centerPanel.setBounds(0, 0, 900, 800);
		centerPanel_2.setLayout(null);
		centerPanel_2.setBounds(0, 0, 900, 800);
		
		centerPanel.setVisible(true);
		centerPanel_2.setVisible(true);
		panel.add(centerPanel);
		panel.add(centerPanel_2);

		rd1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel_2.setVisible(false); // 창 안보이게 하기
				centerPanel.setVisible(true);
			}
		});
		
		rd2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerPanel.setVisible(false); // 창 안보이게 하기
				centerPanel_2.setVisible(true);
			}
		});
		
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
}
