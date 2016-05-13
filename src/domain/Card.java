package domain;

public class Card {
	private int value;
	private CardColor color;

	public Card(int v, CardColor cc){
		this.value=v;
		this.color = cc;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public CardColor getColor(){
		return this.color;
	}

	public String toString(){
		return "Karte: " + color.toString() + " " + value;
	}
}
