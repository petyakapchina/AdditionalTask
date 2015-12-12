import java.util.Scanner;

public class LettersTransfer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text: ");
		String text = sc.next();

		text = text.toUpperCase();

		if (text.length() % 2 != 0) {
			text += "P";
		}
		 
		Transform letters  = new Transform(text);
		System.out.println("For encrypt choose 1.");
		System.out.println("For decrypt choose 2.");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			letters.encrypt();
			break;
		case 2:
			letters.decrypt();
			break;
		default:
			System.out.println("Inncorretc input!");

		}
		for (int index = 0; index < letters.letters.length; index++) {
			System.out.print(letters.letters[index] + " ");
		}
		sc.close();
	}
}
