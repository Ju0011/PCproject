package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JSpinner;

public class OrderTest extends JFrame {
	
	int count = 0;
	String show = "";
	JButton jProduct,jOk;
	TextField txtPrice;
	Label lblName;
	
	public OrderTest() {
		
		
		// 디자인단
        // 프레임 설정단
        JFrame frame = new JFrame("물건 판매기");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);
 
        // 폰트
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // 북쪽
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(255, 255, 215));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);
 
        // 배열 설정 부분
        String menu[] = { "소주","맥주","과자","피자","버거","김밥","라면","콜라","담배" };
        int price[] = { 5500, 5500, 2000, 4500, 3000, 2500, 2000, 1500,4500 };
        JButton jProduct[] = new JButton[menu.length];
        TextField txtPrice[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton jOk[] = new JButton[menu.length];
        Label lblName[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];
 
        // 버튼 설정 부분
        for (int i = 0; i < menu.length; i++) {
 
            // 햄버거 버튼
        	jProduct[i] = new JButton(menu[i]);
            if (i < 4) {
            	jProduct[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
            	jProduct[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            icon[i] = new ImageIcon(i + ".png");
            jProduct[i].setIcon(icon[i]);
 
            // 숫자 txt 버튼
            txtPrice[i] = new TextField("0");
            txtPrice[i].setBackground(Color.white);
            txtPrice[i].setEditable(false);
            txtPrice[i].setBounds(jProduct[i].getX() + 30, jProduct[i].getY() + 130, 40, 20);
 
            // "-" 버튼
            minus[i] = new Button("-");
            minus[i].setBounds(jProduct[i].getX(), txtPrice[i].getY(), 20, 20);
            minus[i].setEnabled(false);
 
            // "+" 버튼
            plus[i] = new Button("+");
            plus[i].setBounds(jProduct[i].getX() + (100 - 20), txtPrice[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // 가격
            lblName[i] = new Label(price[i] + "원");
            lblName[i].setBounds(jProduct[i].getX() + 20, txtPrice[i].getY() - 25, 100, 20);
 
            // 확인 버튼
            jOk[i] = new JButton("확인");
            jOk[i].setBounds(jProduct[i].getX(), txtPrice[i].getY() + 30, 100, 20);
            jOk[i].setEnabled(false);
 
            pNorth.add(jProduct[i]);
            pNorth.add(txtPrice[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]);
            pNorth.add(lblName[i]);
            pNorth.add(jOk[i]);
        }
 
        // 중앙
        TextArea txtArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        txtArea.setText("   상품명     단가      수량        합계\n\n");
        txtArea.setBackground(Color.white);
        txtArea.setEditable(false);
        txtArea.setFont(font1);
 
        // 남쪽
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(255, 255, 215));
 
        Button jProduct1 = new Button("결제");
        Button jProduct2 = new Button("초기화");
        Button jProduct3 = new Button("닫기");
        pSouth.add(jProduct1);
        pSouth.add(jProduct2);
        pSouth.add(jProduct3);
 
        // 결제버튼   데이터를 장바구니 테이블로 넘겨줘야한다. 수량은 줄어들어야 한다.
        jProduct1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, txtArea.getText() + " 결제되었습니다. \n이용해주셔서 감사합니다.");
                
                for (int i = 0; i < menu.length; i++) {
                    jProduct[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    txtPrice[i].setText("0");
                    txtArea.setText("   상품명     단가      수량        합계\\n\\n");
                  
 
                }
            }
        });
 
        // 초기화 버튼
        jProduct2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    jProduct[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    txtPrice[i].setText("0");
                    txtArea.setText("   상품명     단가      수량        합계\\n\\n");
 
                }
            }
        });
 
 
        //jProduct3 닫기버튼
        
        jProduct3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
 
        // 컴포넌트
        frame.add(pNorth, BorderLayout.NORTH);
        frame.add(txtArea, BorderLayout.CENTER);
        frame.add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        // 이벤트단
        for (int i = 0; i < menu.length; i++) {
            int j = i;
 
            // 제품 버튼 이벤트
            jProduct[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    jProduct[j].setEnabled(false);
                    jOk[j].setEnabled(true);
 
                    count = 0;
                }
            });
 
            // "-" 버튼 이벤트
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        txtPrice[j].setText(count + "");
                        jOk[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" 버튼 이벤트
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    txtPrice[j].setText(count + "");
                    jOk[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //확인 버튼 이벤트
            //getActionCommand -> 컴포넌트 텍스트 값을, getSource()는 레퍼선스 변수명을 
            jOk[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                
                    show = jProduct[j].getActionCommand();
                    txtArea.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                            + "원" + "\n");
                    jOk[j].setEnabled(false);
                }
            });
 
        }
 
        // 끄기
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
 
    // 메인
    public static void main(String[] args) {
        new OrderTest();
    }
 
}
