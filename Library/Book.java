
import java.util.Calendar;
import java.util.Date;

public class Book extends Reading implements Comparable<Book>, Runnable {

	private String author;
	private Calendar dateOfIssue;
	private BookCategory category;
	private static int fee = 2;
	private boolean isTaken = false;

	public Book(String name, String author, String publisher, Calendar date, BookCategory cat, Library lib) {
		super(name, publisher, lib);
		this.setAuthor(author);
		this.setCategory(cat);
		this.setDateOfIssue(date);
		getLibrary().addBook(this);
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		if (author != null && author.length() > 0)
			this.author = author;
	}

	public Date getDateOfIssue() {
		return dateOfIssue.getTime();
	}

	private void setDateOfIssue(Calendar dateOfIssue) {
		if (dateOfIssue != null)
			this.dateOfIssue = dateOfIssue;
	}

	public BookCategory getCategory() {
		return category;
	}

	private void setCategory(BookCategory category) {
		this.category = category;
	}

	@Override
	public int compareTo(Book o) {
		if (o != null) {
			if (this.dateOfIssue.after(o.getDateOfIssue())) {
				return -1;
			}
		}
		return 1;
	}

	public int getFee() {
		return fee;
	}

	@Override
	public void run() {
		if (isTaken) {
			try {
				Thread.sleep(300000);
				System.out.println("Book " + this.getName() + " has been taken.");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void registerIntake(Client c) {
		Calendar now = Calendar.getInstance();
		Record r = new Record(now);
		now.add(Calendar.DAY_OF_WEEK, 3);
		r.setReturnedDate(now);
		addRecord(r, c);
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_WEEK, 5);
		System.out.println(c.getTime());

	}
	
	public void setIstaken(){
		this.isTaken=false;
	}

}
