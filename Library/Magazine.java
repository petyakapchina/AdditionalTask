import java.util.Calendar;
import java.util.Date;

public class Magazine extends Reading implements Comparable<Magazine> {
	private MagaizneCategory category;
	private int numberOfIssue;
	private Calendar dateOfIssue;

	public Magazine(String name, String publisher, Calendar date, MagaizneCategory cat, int number, Library lib) {
		super(name, publisher, lib);
		this.setCategory(cat);
		this.setDateOfIssue(date);
		this.setNumberOfIssue(number);
		getLibrary().addMagazine(this);
	}

	public MagaizneCategory getCategory() {
		return category;
	}

	private void setCategory(MagaizneCategory category) {
		this.category = category;
	}

	public int getNumberOfIssue() {
		return numberOfIssue;
	}

	private void setNumberOfIssue(int numberOfIssue) {
		if (numberOfIssue > 0)
			this.numberOfIssue = numberOfIssue;
	}

	public Date getDateOfIssue() {
		return dateOfIssue.getTime();
	}

	private void setDateOfIssue(Calendar dateOfIssue) {
		if (dateOfIssue != null)
			this.dateOfIssue = dateOfIssue;
	}

	@Override
	public int compareTo(Magazine m) {
		if (m != null) {
			if (m.getName().equals(this.getName())) {
				if (m.getNumberOfIssue() > this.getNumberOfIssue()) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return m.getName().compareTo(this.getName());
			}
		}
		return 0;
	}

}
