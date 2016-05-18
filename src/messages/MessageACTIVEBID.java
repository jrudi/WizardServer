package messages;

public class MessageACTIVEBID extends Message{
	private static final long serialVersionUID = 1L;

	private String username;
	public MessageACTIVEBID(String name){
		super(MessageType.ACTIVEBID);
		this.username = name;
	}
	
	public String getName(){
		return this.username;
	}
}
