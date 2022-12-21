package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Data {
	private static Connection con; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "8103";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/pcproject?serverTimezone=UTC";//DBMS접속할 db명
    static Statement stmt = null;

    
	static String id;
	static String pw;
	static int time;
	static int checkingtime;
	
	
    public Data(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connect Success!");
        } catch(Exception e) {
            System.out.println("Connect Failed!");
            e.printStackTrace();
        } finally {
                try {
                    if(con != null && !con.isClosed()) {
                        //con.close();	//종료시 서버의 리소스 낭비를 방지하기 위해 항상 Connection 객체를 닫아준다.(자원해제)
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
        }
    }
    
    boolean logincheck(String _i, String _p) {
		boolean check = false;
		
		id = _i;
		pw = _p;
		
		try {
			String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
			
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(checkingStr);
			
			
			while(result.next()) {
				if(pw.equals(result.getString("password"))) {
					check = true;
				}
			}
		} catch(Exception e) {
			check = false;
			System.out.println("로그인 실패 > " + e.toString());
		}
		
		return check;
	}
    
    boolean joinCheck(String _i, String _pw, String _a, String _phone, String _n) {
    	boolean check = false;
    	
    	id = _i;
    	pw = _pw;
    	String age = _a;
    	String phone = _phone;
    	String name = _n;
    		
    	try {
  
    		String insertStr =  " INSERT INTO member(id, password, age, phone, name) "
 	               +  " VALUES('" + id + "','" + pw + "','" + age + "','" + phone + "','" + name + "')";
    		
    		stmt = con.createStatement();
    		stmt.executeUpdate(insertStr);
    			
    		check = true;
    		System.out.println("회원가입 성공");
    	} catch(Exception e) {
    		check = false;
    		System.out.println("회원가입 실패 > " + e.toString());
    	}
    		
    	return check;
    }
    
    public boolean ChargeCheck(String _i, int _time) {
    	boolean check = false;
    	
    	id = _i;
    	time = _time;
    		
    	try {	
    		
    		String checkingStr = "SELECT time FROM member WHERE id = '" + id + "'";
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(checkingStr);

			while (result.next()) {
				checkingtime = result.getInt(1);
			}
			
    		String insertStr = "UPDATE member SET time = '" + (checkingtime+time) + "' WHERE id = '" + id + "'";

    		
    		stmt = con.createStatement();
    		stmt.executeUpdate(insertStr);
    			
    		check = true;
    		System.out.println("충전 성공");
    	} catch(Exception e) {
    		check = false;
			System.out.println("충전 실패 > " + e.toString());
		}

		return check;
	}

	public static int TimeCheck(String _i) {
		id = _i;
		try {
			String checkingStr = "SELECT time FROM member WHERE id = '" + id + "'";
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(checkingStr);

			while (result.next()) {
				checkingtime = result.getInt(1);
			}

		} catch (Exception e) {

			System.out.println("검색 실패 > " + e.toString());
		}
		return checkingtime;
	}

    public static String getID() {		
		return id;
	}
	public static String getPass() {		
		return pw;
	}
	public static int getTime() {		
		return checkingtime;
	}
}
