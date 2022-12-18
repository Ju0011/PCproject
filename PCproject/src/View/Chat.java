package View;

import java.net.Socket;

import ChatClient.*;
import ChatServer.*;

public class Chat {
	static Socket socket;
	MultiChatServer server;
	MultiChatClient Client;
	ClientFrame ClientFrame;
	public Chat() {
		
		
		
	}
	public static void main(String[] args) {
		Chat chat = new Chat();
		chat.server = new MultiChatServer();
		chat.Client = new MultiChatClient();
		chat.ClientFrame = new ClientFrame(socket);
	}
	
}
