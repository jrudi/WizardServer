package messages;

import java.util.ArrayList;

public class MessageROUNDEND extends Message{
	
	private int round;
	private ArrayList<String> scores;
	public MessageROUNDEND(int newRound, ArrayList<String> setScores){
		super(MessageType.ROUNDEND);
		this.round = newRound;
		this.scores = setScores;
		
	}
	public int getRound() {
		return round;
	}
	
	public ArrayList<String> getScores() {
		return scores;
	}
	
}
