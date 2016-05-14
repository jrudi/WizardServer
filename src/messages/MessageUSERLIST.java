package messages;

import java.util.ArrayList;

public class MessageUSERLIST extends Message{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> userlist;
	
	public MessageUSERLIST(ArrayList<String> users){
		super(MessageType.USERLIST);
		this.userlist = users;
	}

	public ArrayList<String> getUserlist() {
		return userlist;
	}
}
