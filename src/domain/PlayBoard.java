package domain;

import java.util.ArrayList;
import java.util.Collections;

import exceptions.NoCardsLeftException;

public class PlayBoard {

	private ArrayList<Card> deck, played;

	public void createDeck() {
		deck = new ArrayList<Card>();

		for (CardColor cc : CardColor.values()) {
			if(!cc.equals(CardColor.FOOL) && !cc.equals(CardColor.WIZARD)){
			for (int i = 1; i < 14; i++) {
				deck.add(new Card(i, cc));
			}
			}
		}
		deck.add(new Card(0,CardColor.FOOL));
		deck.add(new Card(0,CardColor.FOOL));
		deck.add(new Card(0,CardColor.FOOL));
		deck.add(new Card(0,CardColor.FOOL));
		deck.add(new Card(14,CardColor.WIZARD));
		deck.add(new Card(14,CardColor.WIZARD));
		deck.add(new Card(14,CardColor.WIZARD));
		deck.add(new Card(14,CardColor.WIZARD));

		Collections.shuffle(deck);
	}
	
	public void addCurrentRound(ArrayList<Card>cc){
		for(Card c:cc){
			playCard(c);
		}
	}
	private void playCard(Card c){
		played.add(c);
	}
	
	public Card drawCard(){
		if(deck.size()>0){
			return deck.remove(0);
		}else{
			throw new NoCardsLeftException();
		}
	}

	public static void main(String[] args) {
		PlayBoard pb = new PlayBoard();
		pb.createDeck();
		for(Card c:pb.deck){
			System.out.println(c);

		}
	}
}
