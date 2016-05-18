package controller;

import java.util.ArrayList;

import domain.*;

public class Trick {
	ArrayList<Card> cards;
	CardColor trump;
	
	public Trick(CardColor trumptype){
		this.trump = trumptype;
		cards = new ArrayList<Card>();
	}
	
	public void playCard(Card c){
		cards.add(c);
	}
	/**
	 * compares two cards, assuming first cardcolor == follow suit
	 * @param c1 first card (currently leading)
	 * @param c2 second card
	 * @return 1 if c1 is bigger -1 if c2 is higher 
	 */
	private int compare(Card c1,Card c2){
		if(c1.getColor().equals(CardColor.WIZARD)){	
			return 1;
		}else if(c2.getColor().equals(CardColor.WIZARD)){
			return -1;
		}else if(c1.getColor().equals(CardColor.FOOL)){
			return c1.getColor().equals(CardColor.FOOL) ? 1 : -1;
		}else if(c1.getColor().equals(trump)){
			if(c2.getColor().equals(trump)){
				return (c1.getValue()>c2.getValue()) ? 1 : -1;
			}else{
				return 1;
			}
		}else if(c2.getColor().equals(trump)){
			return -1;
		}else if(c1.getColor().equals(c2.getColor())){
			return c1.getValue()>c2.getValue() ? 1 : -1;
			
		}else{
			return 1;
		}
	}
		
	public int getWinner(){
		Card winner = cards.get(0);
		for(int i=1;i<cards.size();i++){
			winner = compare(winner,cards.get(i))>0?winner:cards.get(i);
		}
		return cards.indexOf(winner);
			
	}
	public static void main(String[] args) {
		Trick t = new Trick(CardColor.BLUE);
		t.playCard(new Card(1,CardColor.RED));
		t.playCard(new Card(11,CardColor.GREEN));
		t.playCard(new Card(9,CardColor.BLUE));
		t.playCard(new Card(12,CardColor.WIZARD));
		System.out.print(t.cards.get(t.getWinner()));
	}
}
