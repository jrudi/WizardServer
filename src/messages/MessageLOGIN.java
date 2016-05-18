package messages;

public class MessageLOGIN extends Message{
	private static final long serialVersionUID = 1L;

	private String username;
	
	public MessageLOGIN(String name){
		super(MessageType.LOGIN);
		this.username = name;
	}
	
	public String getName(){
		return this.username;
	}
}
