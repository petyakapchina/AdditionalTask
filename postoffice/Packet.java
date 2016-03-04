package postoffice;

public class Packet extends MailObject {

	private static final double feeToSend = 2.0;

	private int parameter;
	private double fee = feeToSend;

	public Packet(Person sender, Person reciever, int parameter, boolean isFragile) {
		super(sender, reciever);
		this.setFragile(isFragile);
		this.setParameter(parameter);
		this.setFeeToSend(fee);
		this.setIsLetter(false);
	}

	public int getParameter() {
		return parameter;
	}

	private void setParameter(int parameter) {
		if (parameter > 0) {
			this.parameter = parameter;
			if (parameter >= 60) {
				this.fee += fee * 1.5;
			}
		}
	}

	@Override
	public void setFragile(boolean is) {
		super.setFragile(is);
		if (is) {
			this.fee += fee * 1.5;
		}
	}

	public double getFeeToSend() {
		return this.fee;
	}

}
