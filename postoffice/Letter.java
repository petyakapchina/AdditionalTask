package postoffice;

public class Letter extends MailObject {

	private static final double feeForLetter = 0.5;

	public Letter(Person sender, Person reciever) {
		super(sender, reciever);
		this.setFeeToSend(feeForLetter);
		this.setIsLetter(true);
		this.setISFragile(false);
	}

}
