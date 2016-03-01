import java.util.Calendar;

public class StudentBook extends Reading implements Comparable<StudentBook>, Runnable {
	private String author;
	private SBCategory subject;
	private boolean isTaken=false;
	
	private static int fee=3;

	public StudentBook(String name,String publisher, String auhor, SBCategory cat, Library lib) {
		super(name, publisher, lib);
		this.setAuthor(auhor);
		this.setSubject(cat);
		getLibrary().addStudentBook(this);		
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		if (author != null && author.length() > 0)
			this.author = author;
	}

	public SBCategory getSubject() {
		return subject;
	}

	private void setSubject(SBCategory subject) {
		this.subject = subject;
	}

	@Override
	public int compareTo(StudentBook o) {
		if(o!=null){
			return this.getName().compareTo(o.getName());
		}
		return 0;
	}
	
	public int getFee(){
		return fee;
	}

	@Override
	public void run() {
		if(isTaken){
			try {
				Thread.sleep(150000);
			} catch (InterruptedException e) {
				System.out.println("Magazine "+this.getName()+" has been taken!");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void registerIntake(Client c) {
		Calendar now = Calendar.getInstance();
		Record r = new Record(now);
		now.add(Calendar.DAY_OF_WEEK, 5);
		r.setReturnedDate(now);
		addRecord(r,c);
	}

}
