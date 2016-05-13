package messages;

public class MessageLOGIN extends Message{

	private String username;
	
	public MessageLOGIN(String name){
		super(MessageType.LOGIN);
		this.username = name;
	}
	
	public String getName(){
		return this.username;
	}
}
