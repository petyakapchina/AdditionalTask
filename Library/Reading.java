
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class Reading implements Readable {

	private String name;
	private String publisher;
	private Map<Record, Client> records;
	private Library lib;

	public Reading(String name, String publisher, Library lib) {
		if (lib != null) {
			this.lib = lib;
			this.setName(name);
			this.setPublisher(publisher);
			this.records = new TreeMap<Record, Client>();
		}
	}

	public void addRecord(Record r, Client c) {
		if (r != null && c != null) {
			this.records.put(r, c);
		}
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name != null && name.length() > 0)
			this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	private void setPublisher(String publisher) {
		if (publisher != null && publisher.length() > 0)
			this.publisher = publisher;
	}

	public String getLibraryName() {
		return this.lib.getName();
	}

	public Library getLibrary() {
		return this.lib;
	}

	public Record getRecord() {
		Record last = new Record(Calendar.getInstance());
		for (Record r : records.keySet()) {
			last = r;
		}
		return last;
	}

	public Client getClient() {
		Client last = new Client(new Library("Non"));
		for (Iterator<Record> it = records.keySet().iterator(); it.hasNext();) {
			last = records.get(it.next());
		}
		return last;
	}
}
