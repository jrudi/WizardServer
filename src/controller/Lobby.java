package controller;

import connection.*;
import java.util.ArrayList;


public class Lobby {
	private ArrayList<User> users;
	private ArrayList<Match> matches;
	
	
	public Lobby(){
		users = new ArrayList<User>();
		matches = new ArrayList<Match>();
	}
	
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	public void generateMatch(){
		Match match = new Match();
		match.addUsers(users);
		users.removeAll(users);
		matches.add(match);
	}

	public void addUser(User u){
		users.add(u);
		if(users.size()==4){
			generateMatch();
		}
	}
	
	public void removeUser(User u){
		users.remove(u);
	}
	
	public boolean existsUser(String name){
		for(User u:users){
			if(u.getUsername().equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}
}
