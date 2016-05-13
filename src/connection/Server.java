package connection;

import java.io.*;
import java.net.*;
import controller.*;

public class Server {
	
	private ServerSocket server;
	private Lobby lobby = new Lobby();
	
	public Server() {
		try {
			this.server = new ServerSocket(13337);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listen() {
		try {
			while(true) {
				Socket client = this.server.accept();

				User session = new User(client, this);
				session.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Lobby getLobby(){
		return this.lobby;
	}
	
	public static void main(String[] args) {
        Server server = new Server();
        server.listen();
    }

	
}
