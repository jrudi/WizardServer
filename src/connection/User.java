package connection;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import controller.Match;
import domain.Card;
import messages.*;

public class User extends Thread {

	private Socket socket;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Server server;
	
	private String username;
	private Match match;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private int bid = -1, bidcount = 0;
	
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
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
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

	public void run() {
		while (running) {
			try {
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
						//server.getLobby().generateMatch();
					}
					break;
				case BID:
					match.broadcast(m);
					break;
				case CARDPLAYED:
					match.broadcast(m);
					break;
				case READY:
					ready = ((MessageREADY) m).isReady();
					match.allReady();
					break;
				default:
					break;
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public int wonTrick(){
		bidcount++;
		return bidcount;
	}
	
	public int getBid(){
		return bid;
	}
	
	public String toString(){
		return this.username;
	}
}
