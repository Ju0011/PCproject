package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SeatSet extends JFrame {
    
    int x = 50, y = 50;
    JPanel panel =  new JPanel();
    //NullSeat[] seat = new NullSeat[16]; 배열 시도중
    
    SeatBtn btn1 = new SeatBtn(0);
    
    NullSeat seat1 = new NullSeat(0);
    NullSeat seat2 = new NullSeat(1);
    NullSeat seat3 = new NullSeat(2);
    NullSeat seat4 = new NullSeat(3);
    NullSeat seat5 = new NullSeat(4);
    
    public SeatSet() {
        setLayout(null);
        setVisible(false);	//로그인 창에서 뜨지 않기 위해
        setTitle("좌석창");
        setSize(1400, 800);
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(80, 20); //창 시작 지점
        
        panel.setLayout(null);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(new Color(131, 220, 183));
        
        
        //좌석 버튼
        seat1.setBounds(50, 50, 99, 99);
        panel.add(seat1);
        
        btn1.setBounds(150, 50, 99, 99);
        panel.add(btn1);
       

        
        add(panel);
    }

	public static void main(String[] args) throws Exception {
    	new SeatSet();
    }
 
}
