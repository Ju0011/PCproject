package Test.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener {
	
	private JTextArea txtA = new JTextArea(40, 25);
	private JTextField txtF = new JTextField(25);
	private ServerBackground server = new ServerBackground();

	public ServerGui() throws IOException {

		add(txtA, BorderLayout.CENTER);
		add(txtF, BorderLayout.SOUTH);
		txtF.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 100, 400, 600);
		setTitle("관리자");

		server.setGui(this);
		server.setting();
	}

	public static void main(String[] args) throws IOException {
		new ServerGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "서버 : "+ txtF.getText() + "\n";
		server.sendMessage(msg);
		txtF.setText("");
	}

	public void ServerAppendMsg(String msg) {
		txtA.append(msg);
	}

}
