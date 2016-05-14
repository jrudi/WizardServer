package messages;

import domain.Card;

public class MessageCARDPLAYED extends Message{

	
	private static final long serialVersionUID = 1L;
	private Card card;
	private String name;
	
	public MessageCARDPLAYED(Card c, String username){
		super(MessageType.CARDPLAYED);
		this.card = c;
		this.name = username;
	}
	
	public Card getCard(){
		return this.card;
	}
	
	public String getName(){
		return this.name;
	}
}
