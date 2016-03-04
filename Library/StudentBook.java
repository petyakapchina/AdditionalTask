
public class StudentBook extends Reading implements Comparable<StudentBook> {

	private static final int FEE_TO_USE = 3;

	private String author;

	public StudentBook(String name, String publisher, String auhor, GeneralCategory cat, String type, Library lib) {
		super(name, publisher, lib, cat, type);
		this.setAuthor(auhor);
		this.setFee(FEE_TO_USE);
	}

	public String getAuthor() {
		return author;
	}

	private void setAuthor(String author) {
		if (author != null && author.length() > 0)
			this.author = author;
	}

	@Override
	public int compareTo(StudentBook o) {
		if (o != null) {
			return this.getName().compareTo(o.getName());
		}
		return 0;
	}

}
