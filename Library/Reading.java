
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class Reading implements Readable {

	private String name;
	private String publisher;
	private Map<Record, Client> records;
	private Library lib;
	private GeneralCategory category;
	private boolean isTaken = false;
	private static int fee;
	private String type;

	public Reading(String name, String publisher, Library lib, GeneralCategory c, String type) {
		if (lib != null) {
			this.lib = lib;
			this.setName(name);
			this.setPublisher(publisher);
			this.records = new TreeMap<Record, Client>();
			this.setCategory(c);
			this.setType(type);
			lib.addReading(this);
		}
	}

	@Override
	public void addRecord(Record r, Client c) {
		if (r != null && c != null) {
			this.isTaken = true;
		}
	}

	@Override
	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name != null && name.length() > 0)
			this.name = name;
	}

	@Override
	public String getPublisher() {
		return publisher;
	}

	private void setPublisher(String publisher) {
		if (publisher != null && publisher.length() > 0)
			this.publisher = publisher;
	}

	@Override
	public String getLibraryName() {
		return this.lib.getName();
	}

	@Override
	public Library getLibrary() {
		return this.lib;
	}

	@Override
	public Record getRecord() {
		Record last = new Record(Calendar.getInstance());
		for (Record r : records.keySet()) {
			last = r;
		}
		return last;
	}

	public Client getClient() {
		Client last = new Client(new Library("Non"), "Mishok");
		for (Iterator<Record> it = records.keySet().iterator(); it.hasNext();) {
			last = records.get(it.next());
		}
		return last;
	}

	@Override
	public GeneralCategory getCategory() {
		return this.category;
	}

	private void setCategory(GeneralCategory c) {
		this.category = c;
	}

	@Override
	public boolean isTaken() {
		return this.isTaken;
	}

	@Override
	public void setIsTaken(boolean is){
		this.isTaken = is;
	}

	@Override
	public void setFee(int newFee) {
		if (newFee > 0) {
			fee = newFee;
		}
	}

	@Override
	public int getFee() {
		return fee;
	}

	@Override
	public String getType() {
		return this.type;
	}

	private void setType(String type) {
		if (type != null && type.length() > 0) {
			this.type = type;
		}
	}

	@Override
	public String toString() {
		return ("Name: " + this.getName()) + " Publisher: " + this.getPublisher();
	}
}
