package messages;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;

	private MessageType type;
	
	public Message(MessageType type) {
		this.type = type;
	}

	public MessageType getType(){
		return this.type;
	}
}
