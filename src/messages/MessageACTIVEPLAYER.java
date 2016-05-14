package messages;

public class MessageACTIVEPLAYER extends Message{
	private String name;
	
	public MessageACTIVEPLAYER(String username){
		super(MessageType.ACTIVEPLAYER);
		this.name = username;
	}
	
	public String getName(){
		return this.name;
	}
}
