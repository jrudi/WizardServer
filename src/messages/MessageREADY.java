package messages;

public class MessageREADY extends Message{
	private static final long serialVersionUID = 1L;

	private boolean rdy;
	public MessageREADY(boolean ready) {
		super(MessageType.READY);
		this.rdy = ready;
	}
	
	public boolean isReady(){
		return this.rdy;
	}
}
