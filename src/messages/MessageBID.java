package messages;

public class MessageBID extends Message{
	private static final long serialVersionUID = 1L;

	private int bid;
	private String username;
	
	public MessageBID(int b, String name){
		super(MessageType.BID);
		this.bid = b;
	}
	
	public int getBid(){
		return this.bid;
	}
	
	public String getName(){
		return this.username;
	}
}
