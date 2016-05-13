package messages;

public class MessageBID extends Message{
	
	private int bid;
	
	public MessageBID(int b){
		super(MessageType.BID);
		this.bid = b;
	}
	
	public int getBid(){
		return this.bid;
	}
}
