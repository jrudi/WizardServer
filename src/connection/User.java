package connection;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import controller.Match;
import domain.Card;
import messages.*;

public class User extends Thread {

	/** connections */
	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Server server;

	/**
	 * user that is currently logged in for this session ("" means that
	 * currently no user is logged in for this session)
	 */
	private String username;
	private Match match;
	private ArrayList<Card> cards = new ArrayList<Card>();

	/** flag for controlling the loop of this thread */
	private boolean running = true, ready=false;

	public String getUsername() {
		return this.username;
	}
	
	public Match getMatch(){
		return this.match;
	}
	
	public boolean isReady(){
		return ready;
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
			server.getLobby().removeUser(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(Message m) {
		try {
			output.writeObject(m);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawCard(){
		cards.add(match.getBoard().drawCard());
	}
	
	

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public void run() {
		while (running) {
			try {
				Thread.sleep(200);
				Message m = (Message) input.readObject();
				
				switch (m.getType()) {
				case QUIT:
					this.running = false;
					disconnect();
					System.out.println("Quit");
					break;

				case LOGIN:
					MessageLOGIN ml = (MessageLOGIN) m;
					if (server.getLobby().existsUser(ml.getName())) {
						send(new MessageLOGIN_ERROR(ml.getName()));
					} else {
						this.username = ml.getName();
						server.getLobby().addUser(this);
						send(new Message(MessageType.LOGIN));
					}
					break;
				case READY:
					ready = !ready;
				default:
					break;
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public String toString(){
		return this.username;
	}
}
