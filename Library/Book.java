
import java.util.Calendar;
import java.util.Date;

public class Book extends Reading implements Comparable<Book> {

	private static final int FEE_FOR_BOOK = 2;
	private String author;
	private Calendar dateOfIssue;

	public Book(String name, String author, String publisher, Calendar date, GeneralCategory cat, Library lib, String type) {
		super(name, publisher, lib,cat,type);
		this.setAuthor(author);
		this.setDateOfIssue(date);
		this.setFee(FEE_FOR_BOOK);
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
	
	@Override
	public int compareTo(Book o) {
		if (o != null) {
			if (this.dateOfIssue.after(o.getDateOfIssue())) {
				return -1;
			}
		}
		return 1;
	}


	
}
