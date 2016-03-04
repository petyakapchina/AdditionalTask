package postoffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MailBox {

	private static int id = 1;
	private static MailBox box = null;

	private List<MailObject> letters;

	private MailBox() {
		this.letters = new ArrayList<MailObject>();
		id++;
	}

	public static MailBox getInstance() {
		if (id <= 25) {
			box = new MailBox();
		}
		return box;
	}

	public void addLetter(MailObject letter) {
		if (letter != null) {
			this.letters.add(letter);
		}
	}

	public List<MailObject> getAllLettersFromBox() {
		return Collections.unmodifiableList(letters);
	}

	public void emptyBox() {
		this.letters = new ArrayList<MailObject>();
	}
	
}
