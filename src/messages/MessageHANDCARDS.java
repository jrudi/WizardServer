package messages;

import java.util.ArrayList;

import domain.Card;

public class MessageHANDCARDS extends Message{
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> handcards;
	
	public MessageHANDCARDS(ArrayList<Card> cards){
		super(MessageType.HANDCARDS);
	}

	public ArrayList<Card> getHandcards() {
		return handcards;
	}
}
