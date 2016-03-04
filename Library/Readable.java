
public interface Readable {

	void addRecord(Record r, Client c);

	String getName();

	String getPublisher();

	String getLibraryName();

	Library getLibrary();

	Record getRecord();

	GeneralCategory getCategory();

	boolean isTaken();

	void setFee(int newFee);

	int getFee();

	String getType();

	String toString();

	void setIsTaken(boolean is);

}