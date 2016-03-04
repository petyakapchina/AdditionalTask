
import java.util.List;
import java.util.Map;

public class LibraryMan implements Runnable {
	private Library lib;

	public LibraryMan(Library lib) {
		if (lib != null) {
			this.lib = lib;
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Checking for bad clients!");
			Map<GeneralCategory, Map<String, List<Reading>>> books = lib.getAllBooks();
			for (GeneralCategory cat : books.keySet()) {
				for (String type : books.get(cat).keySet()) {
					for (Reading book : books.get(cat).get(type)) {
						if (!book.getRecord().isReturnedInTime()) {
							book.getClient().addToAccount(book.getFee() * 1.01);
							System.out.println(book.getClient().getName() + " is late with returnment!");
						}
					}
				}
			}
		}
	}

	public Library getLib() {
		return lib;
	}

}
