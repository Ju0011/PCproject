package Login;


public class MainTest {
	public LoginTest Login;
	public TestJoin join;
	
	public static void main(String[] args) {
		MainTest main = new MainTest();
		main.Login = new LoginTest();
		main.join = new TestJoin();
	}
}
