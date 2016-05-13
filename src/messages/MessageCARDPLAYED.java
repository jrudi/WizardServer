package messages;

import domain.Card;

public class MessageCARDPLAYED extends Message{

	
	private static final long serialVersionUID = 1L;
	private Card card;
	
	public MessageCARDPLAYED(Card c){
		super(MessageType.CARDPLAYED);
		this.card = c;
	}
	
	public Card getCard(){
		return this.card;
	}
}
