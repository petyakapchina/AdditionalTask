import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library implements Runnable {

	private String name;

	private Map<BookCategory, List<Book>> books = new TreeMap<BookCategory, List<Book>>();
	private Map<MagaizneCategory, List<Magazine>> magazines = new TreeMap<MagaizneCategory, List<Magazine>>();
	private Map<SBCategory, List<StudentBook>> studenstBooks = new TreeMap<SBCategory, List<StudentBook>>();

	public Library(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		}
	}

	public void addBook(Book b) {
		if (b != null) {
			if (books.containsKey(b.getCategory())) {
				books.get(b.getCategory()).add(b);
			}
			List<Book> bs = new ArrayList<Book>();
			bs.add(b);
			books.put(b.getCategory(), bs);
		}
	}

	public void addStudentBook(StudentBook sb) {
		if (sb != null) {
			if (studenstBooks.containsKey(sb.getSubject())) {
				studenstBooks.get(sb.getSubject()).add(sb);
			}
			List<StudentBook> sbs = new ArrayList<StudentBook>();
			sbs.add(sb);
			studenstBooks.put(sb.getSubject(), sbs);
		}
	}

	public void addMagazine(Magazine m) {
		if (m != null) {
			if (magazines.containsKey(m.getCategory())) {
				magazines.get(m.getCategory()).add(m);
			}
			List<Magazine> ms = new ArrayList<Magazine>();
			ms.add(m);
			magazines.put(m.getCategory(), ms);
		}
	}

	public void CatalogeMassage() {
		System.out.println("We provide three types of readings:");
		System.out.println("1. Books;");
		System.out.println("2.Magazines");
		System.out.println("3.Student Books");
		System.out.println("Plaese, enter the number of category you would like to preview.");
	}

	public void previewChoosenCategory(int number) {
		if (number > 0 && number < 4) {
			if (number == 1) {
				this.showBooks();
			}
			if (number == 2) {
				this.showMagazines();
			}
			if (number == 3) {
				this.showStudentBooks();
			}
		}
	}

	public String getName() {
		return this.name;
	}

	private void showBooks() {
		for (BookCategory b : books.keySet()) {
			System.out.println("Category: " + b);
			for (Book book : books.get(b)) {
				System.out.println(b);
			}
		}
	}

	private void showStudentBooks() {
		for (SBCategory b : studenstBooks.keySet()) {
			System.out.println("Category: " + b);
			for (StudentBook book : studenstBooks.get(b)) {
				System.out.println(b);
			}
		}
	}

	private void showMagazines() {
		for (MagaizneCategory b : magazines.keySet()) {
			System.out.println("Category: " + b);
			for (Magazine book : magazines.get(b)) {
				System.out.println(b);
			}
		}
	}

	public Map<BookCategory, List<Book>> getBooks() {
		return Collections.unmodifiableMap(books);
	}

	public Map<SBCategory, List<StudentBook>> getStudnetBooks() {
		return Collections.unmodifiableMap(studenstBooks);
	}

	public Map<MagaizneCategory, List<Magazine>> getMagazines() {
		return Collections.unmodifiableMap(magazines);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkBooks();
		checkStudentBooks();
		System.out.println("Checking for bad clients!");
	}

	private void checkBooks() {
		for (BookCategory b : books.keySet()) {
			for (Book book : books.get(b)) {
				if (!book.getRecord().isReturnedInTime()) {
					book.getClient().addToAccount(book.getFee() * 1.01);
				}
			}
		}
	}

	private void checkStudentBooks() {
		for (SBCategory b : studenstBooks.keySet()) {
			for (StudentBook book : studenstBooks.get(b)) {
				if (!book.getRecord().isReturnedInTime()) {
					book.getClient().addToAccount(book.getFee() * 1.01);
				}
			}
		}
	}
}
