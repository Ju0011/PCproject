package View;

import java.awt.Component;
import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;



public class SeatSet extends JFrame {
	private JPanel panel = new JPanel();
	
	int x, y;
	NullSeat[] seat = new NullSeat[16];
	
	public SeatSet() {
		setLayout(null);
        setVisible(true);
        setTitle("좌석창");
        setSize(1400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        for (int i = 0; i < 16; i++) {
        	seat[i] = new NullSeat(i);
        	seat[i].setBounds(i*100+30, i*100+30 ,99 ,99);
        	panel.add(seat[i]);
        }
        add(panel);
	}
	
//	public static void main(String[] args) throws Exception {
//    	new SeatSet();
// 
//    }
}
