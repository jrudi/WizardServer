package messages;

import java.util.ArrayList;

public class MessageLOBBY extends Message{
	private static final long serialVersionUID = 1L;

	public MessageLOBBY(ArrayList<ArrayList<String>> list){
		super(MessageType.USERLIST);
		//TODO Change enum or classname to Lobby/userlist
	}
}
