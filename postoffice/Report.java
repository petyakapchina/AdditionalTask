package postoffice;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Report {

	private PostOffice post;
	private Map<Calendar, List<MailObject>> mails = post.getArchive();

	public Report(PostOffice p) {
		this.setPostOffice(p);
	}

	private void setPostOffice(PostOffice p) {
		if (p != null) {
			this.post = p;
		}
	}

	public void getAllMailsFromDate(Calendar date) {
		if (date != null && mails.containsKey(date)) {
			System.out.println("All mails from date: " + date);
			for (Calendar data : mails.keySet()) {
				if (data.equals(date)) {
					for (MailObject m : mails.get(data)) {
						System.out.println(m);
					}
					break;
				}
			}
		}
	}

	public void getPercentOfLettersForTheDay() {
		Calendar now = Calendar.getInstance();
		int countAll = 0;
		int countLetters = 0;
		for (Calendar data : mails.keySet()) {
			if (data.equals(now)) {
				for (MailObject m : mails.get(data)) {
					countAll++;
					if (m.isLetter()) {
						countLetters++;
					}
				}
			}
			System.out.println("Letters to all mail in " + now + " - " + countLetters / countAll * 100 + "%");
		}
	}

	public void getPercentOfFragilePackets() {
		int allPackets = 0;
		int fragilePackets = 0;

		for (Calendar data : mails.keySet()) {
			for (MailObject m : mails.get(data)) {
				if(!m.isLetter()){
					allPackets++;
					if(m.isFragile()){
						fragilePackets++;
					}
				}
			}
		}
		System.out.println("Fragile packets to all packets: "+fragilePackets/allPackets*100+"%");
	}
	
	public void getPostmenActivity(){
		Set<PostWorker> workers = post.getAllWorkers();
		for(PostWorker w:workers){
			System.out.println(w.getFirstName()+" "+w.getLastName()+" "+w.getMailsDelivered()+" deliverd mails.");
		}
	}
}
