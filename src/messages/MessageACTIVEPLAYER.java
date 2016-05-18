package messages;

public class MessageACTIVEPLAYER extends Message{
	private static final long serialVersionUID = 1L;

	private String name;
	
	public MessageACTIVEPLAYER(String username){
		super(MessageType.ACTIVEPLAYER);
		this.name = username;
	}
	
	public String getName(){
		return this.name;
	}
}
