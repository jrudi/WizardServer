package messages;

public class MessageLOGIN_ERROR extends Message{
	private String msg;
	
	public MessageLOGIN_ERROR(String error){
		super(MessageType.LOGIN_ERROR);
		this.msg = "Der Name " + error + " ist schon vergeben.";
	}
	
	public String getError(){
		return this.msg;
	}
}
