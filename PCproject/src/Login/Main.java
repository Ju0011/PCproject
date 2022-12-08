package Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Login.Login.ButtonListener;

public class Main extends JFrame{
	
	BufferedImage img = null;
	
	Data data = null;
	Login login = null;
	public Join join = null;
	
	private JLabel txt;
	private JPanel panel;
	
	/* Panel */
	JPanel centerPanel = new JPanel(new BorderLayout());
	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
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
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1400, 900);
		add(panel);
		
		txt = new JLabel("어서오세요. SK PC방 입니다!");
		txt.setFont(txt.getFont().deriveFont(30.0f));
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
		
		
		idL.setBounds(250, 350, 100, 80);
		idL.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(idL);
		
		pwL.setBounds(250, 440, 300, 80);
		pwL.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(pwL);
		
		id.setBounds(380, 350, 300, 80);
		id.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(id);
		
		pw.setBounds(380, 440, 300, 80);
		pw.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(pw);
		
		loginBtn.setBounds(700, 350, 200, 170);
		loginBtn.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(loginBtn);
		
		joinBtn.setBounds(250, 530, 320, 80);
		joinBtn.setFont(txt.getFont().deriveFont(30.0f));
		panel.add(joinBtn);
		
		nonBtn.setBounds(580, 530, 320, 80);
		nonBtn.setFont(txt.getFont().deriveFont(30.0f));
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
				System.out.println("결제창 구현할 것");
				System.exit(0);
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
					} else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		}
	}

	class MyPanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.data = new Data();
//		main.login = new Login(main);
		main.join = new Join(main);
	}
	
}