package messages;

import java.util.ArrayList;

public class MessageLOBBY extends Message{
	
	public MessageLOBBY(ArrayList<ArrayList<String>> list){
		super(MessageType.USERLIST);
	}
}
