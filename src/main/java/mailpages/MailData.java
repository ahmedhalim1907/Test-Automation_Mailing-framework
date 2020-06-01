package mailpages;

public class MailData {
	private String SenderMail;
	private String SenderPassword;
	private String ReceiverMail;
	private String ReceiverPassword;
	
	//default constructor
	public MailData () {
		
	}
	
	//setters and getters
	public void setSenderMail(String SenderMail) {
		this.SenderMail = SenderMail;
	}
	public String getSenderMail() {
		return SenderMail;
	}
	
	public void setSenderPassword(String SenderPassword) {
		this.SenderPassword = SenderPassword;
	}
	public String getSenderPassword() {
		return SenderPassword;
	}
	
	public void setReceiverMail(String ReceiverMail) {
		this.ReceiverMail = ReceiverMail;
	}
	public String getReceiverMail() {
		return ReceiverMail;
	}
	
	public void setReceiverPassword(String ReceiverPassword) {
		this.ReceiverPassword = ReceiverPassword;
	}
	public String getReceiverPassword() {
		return ReceiverPassword;
	}
	

}
