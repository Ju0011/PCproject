package View;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Test extends JFrame {
 
    public JPanel panel = new JPanel();
    
    int x, y;
    NullSeat[] pan = new NullSeat[16];
    
 
    public Test() {
        
    	
        setLayout(null);
        setVisible(true);
        setTitle("좌석창");
        setSize(1400, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(165, 109, 1368, 686);
        for (int seat = 0; seat < 16; seat++) {
            pan[seat] = new NullSeat(seat);
            if (seat % 10 == 0 && seat != 0) {
                x = 0;
                y += 140;
            }
            pan[seat].setBounds(x, y, 99, 99);
            x += 135;
            panel.add(pan[seat]);
             
        }
        
        add(panel);
    }
 
    public static void main(String[] args) throws Exception {
    	new Test();
    }
 
}
