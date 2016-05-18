package messages;

public class MessageLOGIN_ERROR extends Message{
	private static final long serialVersionUID = 1L;

	private String msg;
	
	public MessageLOGIN_ERROR(String error){
		super(MessageType.LOGIN_ERROR);
		this.msg = "Der Name " + error + " ist schon vergeben.";
	}
	
	public String getError(){
		return this.msg;
	}
}
