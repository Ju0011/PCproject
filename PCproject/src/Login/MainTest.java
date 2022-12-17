package Login;

import View.SeatSet;

public class MainTest {
	public LoginTest Login;
	public TestJoin join;
	private SeatSet seat;
	
	public static void main(String[] args) {
		MainTest main = new MainTest();
		main.Login = new LoginTest();
		main.join = new TestJoin();
		main.seat = new SeatSet();
	}
}
