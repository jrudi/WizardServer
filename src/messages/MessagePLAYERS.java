package messages;

import java.util.ArrayList;

public class MessagePLAYERS extends Message{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> players;
	
	public MessagePLAYERS(ArrayList<String> pp){
		super(MessageType.PLAYERS);
		this.players = pp;
	}
	
	public ArrayList<String> getPlayers(){
		return this.players;
	}
}
