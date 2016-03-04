import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryDemo {
	public static void main(String[] args) {

		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, 1964);
		Library lib = new Library("National Library");
		Reading book = new Book("Vreme razdelno", "Anton Donchev", "Prosveta", date, GeneralCategory.Book, lib,
				"History");
		Reading magazine = new Magazine("ELLE", "Egmont Bulgaria", Calendar.getInstance(), GeneralCategory.Magazine,
				"Fashion", 3, lib);
		Reading studentBook = new StudentBook("Matematika", "Anubis", "Neznam Koi", GeneralCategory.StudentBook,
				"Maths", lib);
		lib.addReading(book);
		lib.addReading(magazine);
		lib.addReading(studentBook);
		
		lib.previewChoosenCategory(GeneralCategory.StudentBook);
		
		
		Thread libraryMan = new Thread(new LibraryMan(lib));
		libraryMan.setPriority(1);
		libraryMan.start();
			
		ExecutorService poolOfClients = Executors.newFixedThreadPool(3);
		poolOfClients.submit(new Client(lib, "Pesho"));
		poolOfClients.submit(new Client(lib, "Gosho"));
		poolOfClients.submit(new Client(lib, "Misho"));
		
		poolOfClients.shutdown();

	}

}
