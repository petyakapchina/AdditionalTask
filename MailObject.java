package postoffice;

public abstract class MailObject {

	private Person sender;
	private Person reciever;
	private double feeToSend;
	private boolean isLetter;
	private boolean isFragile;

	public MailObject(Person sender, Person reciever) {
		this.setReciever(reciever);
		this.setSender(sender);
	}
	
	public Person getSender() {
		return sender;
	}

	private void setSender(Person sender) {
		if (sender != null)
			this.sender = sender;
	}

	public Person getReciever() {
		return reciever;
	}

	private void setReciever(Person reciever) {
		if (reciever != null)
			this.reciever = reciever;
	}

	public double getFeeToSend() {
		return feeToSend;
	}

	public void setFeeToSend(double feeToSend) {
		if (feeToSend > 0)
			this.feeToSend = feeToSend;
	}

	public boolean isLetter() {
		return this.isLetter;
	}

	public void setIsLetter(boolean is) {
		this.isLetter = is;
	}
	
	@Override
	public String toString() {
		String type ="";
		if(isLetter){
			type="Letter";
		}
		else{
			type="Packet";
		}
		return type+" sender: "+this.sender+" reciever: "+this.reciever;
	}
	
	public boolean isFragile(){
		return this.isFragile;
	}
	
	public void setFragile(boolean is){
		this.isFragile=is;
	}

}
