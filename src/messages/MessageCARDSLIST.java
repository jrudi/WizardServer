package messages;

import java.util.ArrayList;
import domain.*;

public class MessageCARDSLIST extends Message{

	private ArrayList<Card> cards;
	
	public MessageCARDSLIST(ArrayList<Card> list){
		super(MessageType.CARDSLIST);
		this.cards = list;
	}
	
	public ArrayList<Card> getCards(){
		return this.cards;
	}

}
