package messages;

import domain.CardColor;

public class MessageTRUMPSUIT extends Message{
	
	private CardColor trump;
	public MessageTRUMPSUIT(CardColor color){
		super(MessageType.TRUMPSUIT);
		this.trump = color;
	}
	
	public CardColor getTrump(){
		return trump;
	}
}
