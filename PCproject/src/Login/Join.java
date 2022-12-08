package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Join extends JFrame {
	/* Panel */
	JPanel panel = new JPanel();
	
	
	/* Label */
	JLabel idL = new JLabel("아이디");
	JLabel pwL = new JLabel("비밀번호");
	JLabel ageL = new JLabel("나이");
	JLabel phoneL = new JLabel("연락처");
	JLabel nameL = new JLabel("이름");
	
	/* TextField */
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	JTextField age = new JTextField();
	JTextField phone = new JTextField();
	JTextField name = new JTextField();
	
	/* Button */
	JButton joinBtn = new JButton("가입하기");
	JButton cancelBtn = new JButton("가입취소");
	JButton checkBtn = new JButton("중복확인");
	
	Main o = null;
	
	Join(Main _o) {
		o = _o;
		
		
		setTitle("회원가입");
		
		/* Panel 추가 */
		setContentPane(panel);
		
		panel.setLayout(null);
		
		idL.setBounds(80, 30, 100, 40);
		idL.setFont(idL.getFont().deriveFont(20.0f));
		id.setBounds(150, 30, 200, 40);
		panel.add(idL);
		panel.add(id);
		
		
		pwL.setBounds(60, 80, 100, 40);
		pwL.setFont(idL.getFont().deriveFont(20.0f));
		pw.setBounds(150, 80, 200, 40);
		panel.add(pwL);
		panel.add(pw);
		
		
		ageL.setBounds(100, 130, 100, 40);
		ageL.setFont(idL.getFont().deriveFont(20.0f));
		age.setBounds(150, 130, 200, 40);
		panel.add(ageL);
		panel.add(age);
		
		phoneL.setBounds(80, 180, 100, 40);
		phoneL.setFont(idL.getFont().deriveFont(20.0f));
		phone.setBounds(150, 180, 200, 40);
		panel.add(phoneL);
		panel.add(phone);
		
		
		nameL.setBounds(100, 230, 100, 40);
		nameL.setFont(idL.getFont().deriveFont(20.0f));
		name.setBounds(150, 230, 200, 40);
		panel.add(nameL);
		panel.add(name);
		
		cancelBtn.setBounds(70, 400, 150, 50);
		joinBtn.setBounds(280, 400, 150, 50);
		panel.add(cancelBtn);
		panel.add(joinBtn);
		
		/* Button 이벤트 리스너 추가 */
		ButtonListener bl = new ButtonListener();
		
		cancelBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	/* Button 이벤트 리스너 */
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			/* TextField에 입력된 회원 정보들을 변수에 초기화 */
			String uid = id.getText();
			String upass = "";
			for(int i=0; i<pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			String uage = age.getText();
			String uphone = phone.getText();
			String uname = name.getText();
			
			/* 가입취소 버튼 이벤트 */
			if(b.getText().equals("가입취소")) {
				dispose();
			}
			
			/* 가입하기 버튼 이벤트 */
			else if(b.getText().equals("가입하기")) {
				if(uid.equals("") || upass.equals("") || uage.equals("") || uphone.equals("") || uname.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("회원가입 실패 > 회원정보 미입력");
				}
				
				else {
					if(o.data.joinCheck(uid, upass)) {
						System.out.println("회원가입 성공");
						JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다");
						dispose();
						
					} else {
						System.out.println("회원가입 실패");
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");
						id.setText("");
						pw.setText("");
					}
				}
			}
		}
	}
}