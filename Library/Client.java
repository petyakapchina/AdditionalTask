import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Client implements Runnable {

	private Library lib;
	private double moneyToPay = 0;
	private String name;
	private Readable whatIreadNow;

	public Client(Library lib, String name) {
		if (lib != null) {
			this.lib = lib;
			this.setName(name);
		}
	}

	private void takeBook(Reading book) {
		book.addRecord(new Record(Calendar.getInstance()), this);
		book.setIsTaken(true);
		this.whatIreadNow = book;
	}

	private void returnBook() {
		System.out.println("You own: " + this.moneyToPay);
		this.moneyToPay = 0;
		this.whatIreadNow.setIsTaken(false);
	}

	public void addToAccount(double d) {
		if (d > 0) {
			this.moneyToPay += d;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0)
			this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			Reading book = this.generateBook();
			if(!book.isTaken()){
			this.takeBook(book);
			System.out.println("I, " + name + ", have just taken " + book.getName());
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("I, " + name + ", have just returned " + whatIreadNow.getName());
			returnBook();
			}
			else{
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private Reading generateBook() {
		Map<GeneralCategory, Map<String, List<Reading>>> allBooks = lib.getAllBooks();
		int number = (int) (Math.random() * 10);
		if (number <= 3) {
			return allBooks.get(GeneralCategory.Book).get("History").get(0);

		}
		if (number > 3 && number <= 6) {
			return allBooks.get(GeneralCategory.Magazine).get("Fashion").get(0);
		} else {
			return allBooks.get(GeneralCategory.StudentBook).get("Maths").get(0);
		}
	}

}
