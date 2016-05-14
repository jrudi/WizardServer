package controller;

import java.util.ArrayList;

import domain.*;

public class Trick {
	ArrayList<Card> cards;
	CardColor trump;
	CardColor follow;
	boolean hasFollow;
	public Trick(CardColor trumptype){
		this.trump = trumptype;
		cards = new ArrayList<Card>();
	}
	
	public void playCard(Card c){
		cards.add(c);
		if(cards.size()==1){
			if(c.getColor().equals(CardColor.WIZARD)||c.getColor().equals(CardColor.FOOL)){
				hasFollow = false;
			}else{
				hasFollow = true;
				follow = c.getColor();
			}
			
		}
	}
	/**
	 * 
	 * @param c1
	 * @param c2
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
		}else if(c1.getColor().equals(c2.getColor())){
			return c1.getValue()>c2.getValue() ? 1 : -1;
			
		}
		System.out.println(c1.toString() + " " + c2.toString() + " trump " + trump.toString() + " follow " + follow.toString());
		return 0;
	}
		
	public int getWinner(){
		Card winner = cards.get(0);
		if(winner.getColor().equals(CardColor.WIZARD)){
			return 0;
		}
		for(int i=1;i<cards.size();i++){
			if(winner.getColor().equals(CardColor.WIZARD)){
				return i;
			}else if(hasFollow){
				if(winner.getColor().equals(cards.get(i).getColor())){
					
				}
			}
			
			
			
			if(winner.getColor().equals(follow)&& cards.get(i).getColor().equals(follow)){
				
			}
		}
		return 0;
	}
}
