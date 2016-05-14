package controller;

import java.util.ArrayList;
import java.util.HashMap;

import connection.User;
import domain.Card;
import domain.PlayBoard;
import messages.*;

public class Match {
	private ArrayList<User> users;
	private int currentRound = 0;
	private PlayBoard playboard;
	private HashMap<User,Card> roundCards;
	
	public Match(){
		users = new ArrayList<User>();
		playboard = new PlayBoard();
	}
	
	public PlayBoard getBoard(){
		return this.playboard;
	}
	
	public void addUsers(ArrayList<User> list){
		users.addAll(list);
	}
	public void newRound(){
		currentRound++;
		playboard.createDeck();
		for(User u: users){
			
			u.setCards(new ArrayList<Card>());
		}
		drawHands();
	}
	public void drawHands(){
		for(int i=0;i<currentRound;i++){
			for(User u: users){
				u.drawCard();
			}
		}
		for(User u: users){
			u.send(new MessageHANDCARDS(u.getCards()));
		}
	}
	
	public void addplayedCard(User u, Card c){
		roundCards.put(u, c);
	}
	
	public void broadcast(Message m){
		for(User u:users){
			u.send(m);
		}
	}
		
}
