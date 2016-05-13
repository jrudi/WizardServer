package connection;

import java.io.*;
import java.net.*;
import messages.*;

public class User extends Thread {
	
	/** connections */
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Server server;
		
	/** user that is currently logged in for this session ("" means that currently no user is logged in for this session) */
	private String username;
	
	/** flag for controlling the loop of this thread */
	private boolean running;
	
	public String getUsername(){
		return this.username;
	}
	
	User(Socket socket, Server svr) {
		this.server = svr;
		this.socket = socket;
		this.username = "";
		this.running = true;
		this.connect();
	}
	
	private void connect() {
		try {
			this.input = new ObjectInputStream(this.socket.getInputStream());
			this.output = new ObjectOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * closes all connections with the client
	 */
	private void disconnect() {
		try {
			this.output.close();
			this.input.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void send(Message m){
		try {
			output.writeObject(m);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(running){
			try {
				Message m = (Message)input.readObject();
				switch(m.getType()){
				case LOGIN:
					MessageLOGIN ml = (MessageLOGIN) m;
					if(server.getLobby().existsUser(ml.getName())){
						send(new MessageLOGIN_ERROR(ml.getName()));
					}else{
						server.getLobby().addUser(this);
						//send(new MessageLOBBY(server.getLobby().getUsers()));
					}
					break;
				case QUIT:
					disconnect();
					this.running = false;
					break;
				default:
					break;
				}
				//TODO Stuff				
				}catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
