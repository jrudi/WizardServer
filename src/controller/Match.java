package controller;

import java.util.ArrayList;

import connection.User;

public class Match {
	private ArrayList<User> users;
	
	public Match(){
		users = new ArrayList<User>();
	}
	
	public void addUsers(ArrayList<User> list){
		users.addAll(list);
	}
}
