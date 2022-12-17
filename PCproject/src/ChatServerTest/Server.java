package ChatServerTest;

import java.net.*; // ServerSocket, Socket
import java.io.*;  // 입출력

// 동적 배열, 접속한 클라이언트의 정보를 실시간으로 저장하는 목적(고정 배열X)
import java.util.Vector;

public class Server {

    // 클라이언트와 연결할 때만 필요한 ServerSocket 클래스
    ServerSocket ss;
    Socket s;
    // 접속 클라이언트 정보 실시간 저장
    Vector v;

    // ServerThread 자료형 멤버 변수 선언, has-a 관계 설정을 위함
    ServerThread st;

    // 생성자, 멤버 변수 초기화
    public Server() {
        v = new Vector();

        try {
            ss = new ServerSocket(4448);
            System.out.println("ss>>>" + ss);
            System.out.println("채팅 서버 가동중...");

            // 서버 가동: 클라이언트가 접속할 때까지 기다리는 것(무한 대기)
            while (true) {
                // 접속 클라이언트 Socket을 s 변수에 저장
                s = ss.accept();
                System.out.println("Accepted from" + s);

                // 접속 클라이언트와 서버로 st객체 생성
                st = new ServerThread(this, s);

                // 접속할 때마다 v에 접속 클라이언트 스레드 추가
                this.addThread(st);

                // Thread 가동 -> run() -> broadCast() -> send() 실시간 메소드 호출
                st.start();
            }

        } catch (Exception e) {
            // 접속 실패시 간단한 Error 메세지 출력
            System.out.println("서버 접속 실패>>>" + e);
        }
    }

    // 벡터 v에 접속 클라이언트의 스레드 저장
    public void addThread(ServerThread st) {
        v.add(st);
    }

    // 퇴장한 클라이언트 스레드 제거
    public void removeThread(ServerThread st) {
        v.remove(st);
    }

    // 각 클라이언트에게 메세지를 출력하는 메소드, send() 호출
    public void broadCast(String str) {
        for (int i = 0; i < v.size(); i++) {
            // 각각의 클라이언트를 ServerThread 객체로 형 변환 
            ServerThread st = (ServerThread) v.elementAt(i);

            // 각 스레드 객체에 str 문자열을 전송
            st.send(str);
        }
    }
    public static void main(String[] args) {
        // 익명 객체 생성
        new Server();

    }

}
