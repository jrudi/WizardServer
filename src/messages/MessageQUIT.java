package messages;

public class MessageQUIT extends Message{

	private static final long serialVersionUID = 1L;

	public MessageQUIT(){
		super(MessageType.QUIT);
	}
}
