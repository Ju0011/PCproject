package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Login.Data;

public class SeatBtn extends JPanel{
	JButton seat = new JButton();
	
	static int number;
	
	JLabel[] label = new JLabel[4];
	
	int chargeTime = Data.getTime();
	
	Data data = new Data();
	String timeTest;
	
	boolean touch = false;
	
	int time;
	
	public SeatBtn(int numSeat) {
		
		number = numSeat;
		setLayout(null);
		Font font = new Font("SanSerif", Font.BOLD, 12);
		
		//상태정보 패널
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 130, 130);
        
        
        if(chargeTime != 0) {
        	long hour = chargeTime/60;
            long min = chargeTime/3600;
            timeTest = "잔여시간: " + hour +"시간 "+ min+"분";
        }
        
        String id = Data.getID();
        time = Data.TimeCheck(id);
        
        
		int labelY = 10;
		for (int i = 0; i < label.length; i++) {
			if (i == 0)
				label[i] = new JLabel((numSeat + 1) + "번 자리");
			else if (i == 1) {
				if (touch == false) {
					label[i] = new JLabel("");					
				} else {
					label[i] = new JLabel("사용자 : " + Data.getID());					
				}
			} else if (i == 2) {
				if (touch) {
					label[i] = new JLabel("남은시간 :" + time);
				} else
					label[i] = new JLabel("");
				
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
		
		if(touch) {
			seat.setBackground(Color.green);
		}else seat.setBackground(Color.BLACK);

		seat.setBounds(0, 0, 130, 130);

		seat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = Data.getID();
				time = Data.TimeCheck(id);
				touch = true;
				new Charge();
			}
		});

		panel.add(seat);

		panel.setOpaque(false); // 배경색 죽이기

		// 제이레이어패널 - 패널간에 순서 지정가능
		JLayeredPane panLayered = new JLayeredPane();
		panLayered.setLayout(null);
		panLayered.setBounds(0, 0, 200, 200);		
		panLayered.setOpaque(false); // 배경색 죽이기
		panLayered.add(seat); // 버튼
		panLayered.add(panel, new Integer(1));
		add(panLayered);

		setVisible(true);
		setOpaque(false);
		setFocusable(true);
	}
	public static int getseatN() {
		
		return number;
	}
	public static void seat() {
		
	}
}
