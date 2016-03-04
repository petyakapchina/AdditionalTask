package postoffice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostOffice {

	private Map<Calendar, List<MailObject>> archive;
	private BlockingQueue<MailObject> currentAvailability;
	private static Set<PostWorker> staff;
	private static CopyOnWriteArrayList<MailBox> mailBoxes = new CopyOnWriteArrayList<MailBox>();

	public PostOffice() {
		archive = new TreeMap<Calendar, List<MailObject>>();
		staff = new TreeSet<PostWorker>();
	}

	public void addMailObjectToArchive(MailObject m) {
		if (m != null) {

			if (archive.containsKey(Calendar.DAY_OF_MONTH)) {
				List<MailObject> mails = archive.get(Calendar.DAY_OF_MONTH);
				mails.add(m);
			} else {
				List<MailObject> mails = new ArrayList<MailObject>();
				mails.add(m);
			}
		}
	}

	public void addStaff(PostWorker worker) {
		if (worker != null) {
			staff.add(worker);
		}
	}

	public boolean IsThereEnoughLetter() {
		int howManyLetters = currentAvailability.size();
		if (howManyLetters <= 50) {
			return false;
		}
		return true;
	}

	public void putLetterInMailBox(int mailBoxId, MailObject letter) {
		if (letter.isLetter() && mailBoxId >= 0 && mailBoxId < 25) {
			mailBoxes.get(mailBoxId).addLetter(letter);
		}
	}

	public MailBox getBox(int index) {
		if (index >= 0 && index < 25) {
			return mailBoxes.get(index);
		} else {
			try {
				throw new Exception("Unavailable mailbox!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public MailObject giveDeliveryToPostWorker() {
		return currentAvailability.remove();
	}

	public void addMailToCurrentAvailability(MailObject m) {
		if (m != null) {
			this.currentAvailability.offer(m);
		}
	}
	
	public Map<Calendar,List<MailObject>> getArchive(){
		return Collections.unmodifiableMap(archive);
	}
	
	public Set<PostWorker> getAllWorkers(){
		return Collections.unmodifiableSet(staff);
	}



}
