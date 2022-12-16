package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeatSet extends JFrame {
    
    int x, y;
    JPanel panel =  new JPanel();
    NullSeat[] seat = new NullSeat[16];
    
    
    NullSeat seat1 = new NullSeat(0);
//    NullSeat seat2 = new NullSeat(1);
//    NullSeat seat3 = new NullSeat(2);
//    NullSeat seat4 = new NullSeat(3);
//    NullSeat seat5 = new NullSeat(4);
    
    public SeatSet() {
        setLayout(null);
        setVisible(true);
        setTitle("좌석창");
        setSize(1400, 800);
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(80, 20); //창 시작 지점
        
        panel.setLayout(null);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(new Color(131, 220, 183));
        
        seat1.setBounds(50, 50, 99, 99);
        panel.add(seat1);
        add(panel);
    }

	public static void main(String[] args) throws Exception {
    	new SeatSet();
    }
 
}
