package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeatBtn extends JPanel{
	JButton seat = new JButton();
	private static int numSeat;
	
	public Charge charge;
	
	JLabel[] label = new JLabel[4];
	
	
	public SeatBtn(int numSeat) {
		this.numSeat = numSeat;
		setLayout(null);
		Font font = new Font("SanSerif", Font.BOLD, 12);
		
		//상태정보 패널
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 130, 130);
        
		
        /*시간 설정*/
		LocalTime currentTime = LocalTime.now();    // 컴퓨터의 현재 시간 정보        
        //(int hour, int minute, int second, int nanoOfSecond)
        LocalTime targetTime = LocalTime.of(18, 30, 0, 0);
        
        long endTime = Duration.between(currentTime, targetTime).toHours();
        long endMinutes = Duration.between(currentTime, targetTime).toMinutes()%60;
        long endSeconds = Duration.between(currentTime, targetTime).toSeconds()%60;
        
        String time = "잔여시간: " + + endTime +"시간 "+ endMinutes+"분";
        
       
		

		int labelY = 10;
		for (int i = 0; i < label.length; i++) {
			if (i == 0)
				label[i] = new JLabel((numSeat + 1) + "번 자리");
			else if(i == 1) {
				label[i] = new JLabel(time);
			}else {
				label[i] = new JLabel("");
			}
				

			label[i].setBounds(5, labelY, 120, 15);
			labelY += 20;
			label[i].setForeground(new Color(36, 205, 198));
			label[i].setFont(font);
			panel.add(label[i]);
		}

		seat = new JButton();
		seat.setBackground(Color.BLACK);

		seat.setBounds(0, 0, 130, 130);

//		seat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				charge.setVisible(true);
//			}
//		});

		panel.add(seat);

		panel.setOpaque(false); // 배경색 죽이기

		// 제이레이어패널 - 패널간에 순서 지정가능
		JLayeredPane panLayered = new JLayeredPane();
		panLayered.setBounds(0, 0, 200, 200);
		panLayered.setLayout(null);
		panLayered.setOpaque(false); // 배경색 죽이기
		panLayered.add(seat); // 버튼
		panLayered.add(panel, new Integer(1), 0); // 이미지 담을 패널
		add(panLayered);

		setVisible(true);
		setOpaque(false);
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		SeatBtn menu = new SeatBtn(numSeat);
		menu.charge = new Charge();
		
	}
}
