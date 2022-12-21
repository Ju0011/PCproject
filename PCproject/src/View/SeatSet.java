package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeatSet extends JFrame{
	
    int x = 50, y = 50;
    JPanel panel =  new JPanel();
    
    SeatBtn btn1 = new SeatBtn(0);
    
    SeatBtn[] seat = new SeatBtn[16];
    
    
    public SeatSet() {
    	
        setLayout(null);        
        setTitle("좌석창");
        setSize(1400, 800);
        
        setLocation(80, 20); //창 시작 지점
        
        panel.setLayout(null);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(new Color(131, 220, 183));
        
        
        int x = 50, y = 50;
        
		for (int i = 0; i < seat.length; i++) {
			seat[i] = new SeatBtn(i);
			seat[i].setBounds(x, y, 130, 130);
			
			y += 150;
			if(y > 500) {
				x += 200; y = 50;
			}
			
			panel.add(seat[i]);
		}
		add(panel);
		
		
		setVisible(true);	
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws Exception {
    	new SeatSet();
    }

 
}
