import java.util.Calendar;
import java.util.Date;

public class Magazine extends Reading implements Comparable<Magazine> {
	
	private int numberOfIssue;
	private Calendar dateOfIssue;

	public Magazine(String name, String publisher, Calendar date, GeneralCategory cat, String type, int number, Library lib) {
		super(name, publisher, lib, cat, type);
		this.setDateOfIssue(date);
		this.setNumberOfIssue(number);
		
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
	
	@Override
	public void setFee(int newFee) {
		super.setFee(0);
		System.out.println("Free to use!");
	}

}
