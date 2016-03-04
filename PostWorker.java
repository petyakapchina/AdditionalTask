package postoffice;

import java.util.List;
import java.util.Random;

public class PostWorker extends Person implements Runnable, Comparable<PostWorker> {

	private int workingExperiance;
	private boolean isWorking = false;
	private int numberOfMailsDelivered=0;

	public PostWorker(String firstName, String lastName, int experiance, PostOffice office) {
		super(firstName, lastName, office);
		this.setWorkingExperiance(experiance);
		this.getOffice().addStaff(this);
	}

	public int getWorkingExperiance() {
		return workingExperiance;
	}

	private void setWorkingExperiance(int workingExperiance) {
		if (workingExperiance >= 0)
			this.workingExperiance = workingExperiance;
	}

	@Override
	public void run() {
		while (true) {
			if (!this.getOffice().IsThereEnoughLetter()) {
				collectLettersFromBoxes();
			}
			else{
				deliverMailToCitizens();
			}
		}
	}

	private void collectLettersFromBoxes() {
		Random gen = new Random();
		int boxId = gen.nextInt(25) + 1;
		try {
			MailBox box = getOffice().getBox(boxId);
			List<MailObject> letters = box.getAllLettersFromBox();
			isWorking = true;
			if (!letters.isEmpty()) {
				for (MailObject letter : letters) {
					getOffice().addMailObjectToArchive(letter);
					getOffice().addMailToCurrentAvailability(letter);
				}
				box.emptyBox();
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" is collecting letters from mailbox");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isWorking = false;
		}
	}

	public void deliverMailToCitizens() {
		MailObject mail = getOffice().giveDeliveryToPostWorker();
		while (mail != null) {
			if (mail.isLetter()) {
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+" is delevering letter to "+mail.getReciever().getFirstName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					Thread.sleep(1500);
					System.out.println(Thread.currentThread().getName()+" is delevering packet to "+mail.getReciever().getFirstName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.incrementMalisDeleviered();
		}
	}

	public boolean IsWorking() {
		return this.isWorking;
	}
	
	public int getMailsDelivered(){
		return this.numberOfMailsDelivered;
	}
	
	public void incrementMalisDeleviered(){
		this.numberOfMailsDelivered++;
	}

	@Override
	public int compareTo(PostWorker o) {
		if(this.numberOfMailsDelivered>o.numberOfMailsDelivered){
			return 1;
		}
		if(this.numberOfMailsDelivered<o.numberOfMailsDelivered){
			return -1;
		}
		return 0;
	}
	
}
