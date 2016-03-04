package postoffice;

import java.util.Random;

public class Citizen extends Person {

	private String address;
	

	public Citizen(String firstName, String lastName, String address, PostOffice office) {
		super(firstName, lastName, office);
		this.setAddres(address);
	}

	public String getAddres() {
		return address;
	}

	private void setAddres(String address) {
		if (address != null && address.length() > 0)
			this.address = address;
	}

	public void sendLetterViaMailBox(Citizen toWhom) throws Exception {
		if (toWhom != null) {
			Random gen = new Random();
			int boxId = gen.nextInt(25) + 1;
			MailObject letter = new Letter(this, toWhom);
			getOffice().getBox(boxId).addLetter(letter);
		}
	}

	public void sendViaPostOffice(Citizen toWhom, int parameter, boolean isFragile) {
		if (toWhom != null && parameter > 0) {
			int whatToSend = ((int) (Math.random() * 10));
			if (whatToSend <= 5) {
				MailObject letter = new Letter(this, toWhom);
				synchronized (this.getOffice()) {
					this.getOffice().addMailObjectToArchive(letter);
				}
			} else {
				MailObject packet = new Packet(this, toWhom, parameter, isFragile);
				synchronized (this.getOffice()) {
					this.getOffice().addMailObjectToArchive(packet);
				}
			}
		}
	}

}
