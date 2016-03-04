import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Library {

	private String name;

	private Map<GeneralCategory, Map<String, List<Reading>>> allBooks;

	public Library(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
			allBooks = new TreeMap<>();
			allBooks.put(GeneralCategory.Book, new TreeMap<String, List<Reading>>());
			allBooks.put(GeneralCategory.Magazine, new TreeMap<String, List<Reading>>());
			allBooks.put(GeneralCategory.StudentBook, new TreeMap<String, List<Reading>>());

		}
	}

	public void addReading(Reading r) {
		if (r != null) {
			if (allBooks.get(r.getCategory()).get(r.getType())==null) {
				List<Reading> nov = new ArrayList<Reading>();
				nov.add(r);
				allBooks.get(r.getCategory()).put(r.getType(), nov);
			} else {
				allBooks.get(r.getCategory()).get(r.getType()).add(r);
			}
		}
	}

	public void CatalogeMassage() {
		System.out.println("We provide three types of readings:");
		System.out.println("1. Books;");
		System.out.println("2.Magazines");
		System.out.println("3.Student Books");
		System.out.println("Plaese, enter the number of category you would like to preview.");
	}

	public void previewChoosenCategory(GeneralCategory cat) {
		Map<String, List<Reading>> show = allBooks.get(cat);
		for (String type : show.keySet()) {
			System.out.println("Category: " + type);
			for (Reading book : show.get(type)) {
				book.getName();
			}
		}
	}

	public String getName() {
		return this.name;
	}
	
	public Map<GeneralCategory, Map<String,List<Reading>>> getAllBooks(){
		return Collections.unmodifiableMap(this.allBooks);
	}

	

}
