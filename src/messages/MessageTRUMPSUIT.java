package messages;

import domain.CardColor;

public class MessageTRUMPSUIT extends Message{
	
	private static final long serialVersionUID = 1L;
	private CardColor trump;
	public MessageTRUMPSUIT(CardColor color){
		super(MessageType.TRUMPSUIT);
		this.trump = color;
	}
	
	public CardColor getTrump(){
		return trump;
	}
}
