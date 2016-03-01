
public class Client {

	private Library lib;
	private double moneyToPay = 0;

	public Client(Library lib) {
		if (lib != null) {
			this.lib = lib;
		}
	}

	public void takeBook(Book b) {
		if (b != null && lib.getBooks().containsValue(b)) {
			b.registerIntake(this);
		} else {
			System.out.println("Unavailalbe!");
		}
	}
	
	public void returnBook(Book b){
		if(b!=null){
			b.i
		}
	}

	public void takeStudentBook(StudentBook b) {
		if (b != null && lib.getStudnetBooks().containsValue(b)) {
			b.registerIntake(this);
		} else {
			System.out.println("Unavailalbe!");
		}
	}

	public void takeMagazine(Magazine b) {
		if (b != null && lib.getMagazines().containsValue(b)) {
			System.out.println("Magazines cannot be taken home!");
		}
	}

	public void addToAccount(double d) {
		if (d > 0) {
			this.moneyToPay += d;
		}
	}

}
