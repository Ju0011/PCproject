package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SeatBtn extends JPanel{
	JButton[] seat = new JButton[16];
	private int numSeat;
	
	JTextField[] time = new JTextField[16];
	
	
	public SeatBtn(int numSeat) {
		this.numSeat = numSeat;
        
		Font font = new Font("SanSerif", Font.BOLD, 20);
		
		
		LocalTime currentTime = LocalTime.now();    // 컴퓨터의 현재 시간 정보
        System.out.println(currentTime);
        
        
        //(int hour, int minute, int second, int nanoOfSecond)
        LocalTime targetTime = LocalTime.of(15, 20, 0, 0);
        
        long endTime = Duration.between(currentTime, targetTime).toHours();
        long endMinutes = Duration.between(currentTime, targetTime).toMinutes()%60;
        long endSeconds = Duration.between(currentTime, targetTime).toSeconds()%60;
        
        System.out.println("남은시간 : "+ endTime +"시 "+ endMinutes+"분 "+endSeconds+"초");
        
        
		for (int i = 0; i < seat.length; i++) {
			seat[i] = new JButton("<HTML><body><center>" + i + "번 자리<br>" + time[i]+ "</center></body></HTML>");
			seat[i].setFont(font);

			seat[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			add(seat[i]);
		}
	}


	
}
