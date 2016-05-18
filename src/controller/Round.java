package controller;

import connection.User;
import domain.Card;
import domain.CardColor;

public class Round {
	
	private Trick currentTrick;
	private int tricks;
	private CardColor trump;
	private User activePlayer;
	
	public Round(int number, CardColor trumpsuit){
		this.tricks = number;
		this.trump = trumpsuit;
	}
	
	public void newRound(){
		currentTrick = new Trick(trump);
	}
	
	public void playCard(Card c){
		currentTrick.playCard(c);
	}
	
	public int getRoundNumber(){
		return tricks;
	}
	
	public Trick getCurrentTrick(){
		return currentTrick;
	}
	
	public User getActivePlayer(){
		return this.activePlayer;
	}
		
}
