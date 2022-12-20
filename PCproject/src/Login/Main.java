package Login;

import View.SeatSet;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	BufferedImage img = null;	
	Data data = null;
	public Join join = null;
	
	private JLabel txt;
	private JPanel panel;
	
	/* Label */
	JLabel idL = new JLabel("아이디");
	JLabel pwL = new JLabel("비밀번호");
	
	/* TextField */
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	/* Button */
	JButton loginBtn = new JButton("로그인");
	JButton joinBtn = new JButton("회원가입");
	JButton nonBtn = new JButton("비회원");
	

	
	public Main() {
		setTitle("SK PC");
		setSize(1400, 800);
		setLocation(80, 20); //패널 시작 지점
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1400, 900);
		add(panel);
		
		txt = new JLabel("어서오세요. SK PC방 입니다!");
		txt.setFont(new Font("배달의민족 한나", 1, 40));
		txt.setBounds(300, 30, 800, 300);
		panel.add(txt);
		
		
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
		
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		
		idL.setBounds(250, 350, 100, 80);
		idL.setFont(font);
		panel.add(idL);
		
		pwL.setBounds(250, 440, 300, 80);
		pwL.setFont(font);
		panel.add(pwL);
		
		id.setBounds(380, 350, 300, 80);
		id.setFont(font);
		panel.add(id);
		
		pw.setBounds(380, 440, 300, 80);
		pw.setFont(font);
		panel.add(pw);
		
		loginBtn.setBounds(700, 350, 200, 170);
		loginBtn.setFont(font);
		panel.add(loginBtn);
		
		joinBtn.setBounds(250, 530, 320, 80);
		joinBtn.setFont(font);
		panel.add(joinBtn);
		
		nonBtn.setBounds(580, 530, 320, 80);
		nonBtn.setFont(font);
		panel.add(nonBtn);
		
		/* Button 이벤트 리스너 추가 */
		ButtonListener bl = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		nonBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		setResizable(false);	//크기 조절 불가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/* Button 이벤트 */
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			/* TextField에 입력된 아이디와 비밀번호를 변수에 초기화 */
			String uid = id.getText();
			String upass = "";
			
			for(int i=0; i<pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			/* 비회원 로그인 버튼 이벤트 */
			if(b.getText().equals("비회원")) {
				dispose();
				new SeatSet();
			}
			
			/* 회원가입 버튼 이벤트 */
			else if(b.getText().equals("회원가입")) {
				join.setVisible(true);
			}
			
			/* 로그인 버튼 이벤트 */
			else if(b.getText().equals("로그인")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
				
				else if(uid != null && upass != null) {
					if(data.logincheck(uid, upass)) {	//데이터베이스에 접속해 로그인 정보를 확인
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
						dispose();
						new SeatSet();
						
					} else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		}
	}

	public class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.data = new Data();
		main.join = new Join(main);
		
	}
	
	

}