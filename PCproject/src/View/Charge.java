package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Login.Data;
import Login.Main;

public class Charge extends JFrame implements ActionListener{
	
	JPanel panel = new JPanel();
	
	JPanel centerPanel = new JPanel();
	JPanel centerPanel_2 = new JPanel();
	
	TextArea txtArea = new TextArea();
	
	BufferedImage img = null;
	JButton chargebtn = new JButton("충전하기");
	JButton reset = new JButton("초기화");
	JButton close = new JButton("닫기");
	
	JRadioButton rd1 = new JRadioButton("회원 요금");
    JRadioButton rd2 = new JRadioButton("비회원 요금");
	
    JButton[] m_b = new JButton[5];
    JButton[] b = new JButton[5];
    
    String m_time[] = {"1시간", "2시간 20분", "5시간 20분", "11시간", "35시간"};
    String m_charge[] = {"1000원", "2000원", "3000원", "10000원", "30000원"};
    String m_fulltime[] = {"(01:00)", "(02:20)", "(05:20)", "(11:00)", "(35:00)"};
    int IntMTime[] = {60,140,320,660,2100};
    
    String time[] = {"1시간", "2시간", "5시간", "11시간", "35시간"};
    String charge[] = {"1000원", "2000원", "5000원", "11000원", "35000원"};
    String fulltime[] = {"(01:00)", "(02:00)", "(05:00)", "(11:00)", "(35:00)"};   
    int IntTime[] = {60,120,300,600,660,2100};
    
    Data data = new Data();

    
	int x = 200, y = 200;
	static int ChargeTime = 0;
	static int seatnum;
	static String name = null;
	
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

		chargebtn.setBounds(830, 600, 150, 75);
		chargebtn.setFont(new Font("SanSerif", Font.BOLD, 25));
		panel.add(chargebtn);

		reset.setBounds(670, 600, 150, 75);
		reset.setFont(new Font("SanSerif", Font.BOLD, 25));
		panel.add(reset);
		
		close.setBounds(510, 600, 150, 75);
		close.setFont(new Font("SanSerif", Font.BOLD, 25));
		panel.add(close);

		txtArea.setBackground(Color.white);
		txtArea.setEditable(false);	//편집 불가능
        txtArea.setBounds(720, 200, 250, 350);
        txtArea.setFont(font_2);
        panel.add(txtArea);
        
        for (int i = 0; i < m_b.length; i++) {
        	m_b[i]=new JButton("<HTML><body><center>" + m_time[i] + "<br>" + m_fulltime[i]+ "<br>"+m_charge[i]+"</center></body></HTML>");
        	m_b[i].setVisible(true);
        	m_b[i].setFont(font_2);
        	m_b[i].addActionListener(this);
    		centerPanel.add(m_b[i]);
    		
    		b[i]=new JButton("<HTML><body><center>" + time[i] + "<br>" + fulltime[i]+ "<br>"+charge[i]+"</center></body></HTML>");
        	b[i].setVisible(true);
        	b[i].setFont(font_2);
        	b[i].addActionListener(this);
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
		
		chargebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = Data.getID();
				if(data.ChargeCheck(name, ChargeTime)) 
				{
					JOptionPane.showMessageDialog(null, "충전이 완료되었습니다!");				
					dispose(); //현재 창만 닫기
					new Menu();
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					txtArea.setText("");			
			}
		});
		
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
				new Menu();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(centerPanel.isVisible()) {
			int i = Arrays.asList(m_b).indexOf(e.getSource());
			seatnum = i;
			ChargeTime = IntMTime[i];
			txtArea.append("\t" + time[i] + "\t" + charge[i] + "\n");
		}
		
		else if(centerPanel.isVisible() == false) {
			int i = Arrays.asList(b).indexOf(e.getSource());
			seatnum = i;
			ChargeTime = IntTime[i];
			txtArea.append("\t" + time[i] + "\t" + charge[i] + "\n");
		}
	}
	public static int getTime() {
		// getter 밖에서 값을 접근하도록 허용해주는 것
		return ChargeTime;
	}
	
	public static int getseatN() {
		// getter 밖에서 값을 접근하도록 허용해주는 것
		return seatnum;
	}
	public static String getname() {
		// getter 밖에서 값을 접근하도록 허용해주는 것
		return name;
	}
}
