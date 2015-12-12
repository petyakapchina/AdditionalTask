import java.util.Scanner;

public class MorskiShah {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int player1Row = 0;
		int player1Col = 0;
		int player2Row = 0;
		int player2Col = 0;

		Player firstPlayer = new Player(1, 'O');
		Player secondPlayer = new Player(2, 'X');

		Board board = new Board();

		int countMoves = 2;

		while (countMoves <= 9){
			System.out.println("Player 1: ");
			player1Row = sc.nextInt();
			player1Col = sc.nextInt();
			while ((player1Row <= 0 || player1Row >= 4) || (player1Col <= 0 || player1Col >= 4)){
					System.out.println("Inccorect coordinates!");
					System.out.println("Player 1:");
					player1Row = sc.nextInt();
					player1Col = sc.nextInt();
			} 
				
			String checkIfIsTaken = board.checkBoard(player1Row - 1, player1Col - 1);
			if (checkIfIsTaken.equals("Free")) {
				firstPlayer.fillBoard(board, player1Row - 1, player1Col - 1);
				firstPlayer.printMove(board);
			}
			if (checkIfIsTaken.equals("Taken")) {
				do {
					System.out.println("Position taken. Try again!");
					System.out.println("Player 1:");
					player1Row = sc.nextInt();
					player1Col = sc.nextInt();
				} while (checkIfIsTaken.equals("Free"));
				firstPlayer.fillBoard(board, player1Row - 1, player1Col - 1);
				firstPlayer.printMove(board);
			}

			if (!board.checkRows(board.board)) {
				break;
			}
			if (!board.checkCols(board.board)) {
				break;
			}
			if (!board.checkFirstDiagonal(board.board)) {
				break;
			}
			if (!board.checkSecondDiagonal(board.board)) {
				break;
			}

			System.out.println("Player 2: ");
			player2Row = sc.nextInt();
			player2Col = sc.nextInt();
			while ((player2Row <= 0 || player2Row >= 4) || (player2Col <= 0 || player2Col >= 4)){
				System.out.println("Inccorect coordinates!");
				System.out.println("Player 2:");
				player2Row = sc.nextInt();
				player2Col = sc.nextInt();
		} 
			checkIfIsTaken = board.checkBoard(player2Row - 1, player2Col - 1);
			if (checkIfIsTaken.equals("Free")) {
				secondPlayer.fillBoard(board, player2Row - 1, player2Col - 1);
				secondPlayer.printMove(board);
			}
			if (checkIfIsTaken.equals("Taken")) {
				do {
					System.out.println("Position taken. Try again!");
					System.out.println("Player 2: ");
					player2Row = sc.nextInt();
					player2Col = sc.nextInt();
				} while (checkIfIsTaken.equals("Free"));
				secondPlayer.fillBoard(board, player2Row - 1, player2Col - 1);
				secondPlayer.printMove(board);
			}

			countMoves += 2;

			if (!board.checkRows(board.board)) {
				break;
			}
			if (!board.checkCols(board.board)) {
				break;
			}
			if (!board.checkFirstDiagonal(board.board)) {
				break;
			}
			if (!board.checkSecondDiagonal(board.board)) {
				break;
			}

		} 

		if (board.checkRows(board.board) && board.checkCols(board.board) && board.checkFirstDiagonal(board.board)
				&& board.checkSecondDiagonal(board.board)) {
			System.out.println("Equals!");
		}

		sc.close();
	}

}
