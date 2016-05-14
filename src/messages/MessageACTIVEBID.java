package messages;

public class MessageACTIVEBID extends Message{
	private String username;
	public MessageACTIVEBID(String name){
		super(MessageType.ACTIVEBID);
		this.username = name;
	}
	
	public String getName(){
		return this.username;
	}
}
