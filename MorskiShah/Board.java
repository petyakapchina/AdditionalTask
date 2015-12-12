
public class Board {

	char[][] board = new char[3][3];

	Board() {

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				this.board[r][c] = '-';
			}
		}

	}

	String checkBoard(int row, int col) {
		if (this.board[row][col] != '-') {
			return "Taken";
		} else {
			return "Free";
		}
	}

	boolean checkRows(char[][] b) {
		for (int index = 0; index < b.length; index++) {
			if (b[index][0] == b[index][1] && b[index][1] == b[index][2]) {
				if (b[index][0] == 'O') {
					System.out.println("Player 1 wins!");
					return false;
				}
				if (b[index][0] == 'X') {
					System.out.println("Player 2 wins!");
					return false;

				}
			}
		}
		return true;

	}

	boolean checkCols(char[][] b) {
		for (int index = 0; index < b.length; index++) {
			if (b[0][index] == b[1][index] && b[1][index] == b[2][index]) {
				if (b[0][index] == 'O') {
					System.out.println("Player 1 wins!");
					return false;
				}
				if (b[0][index] == 'X') {
					System.out.println("Player 2 wins!");
					return false;

				}
			}
		}
		return true;

	}

	boolean checkFirstDiagonal(char[][] b) {
		if (b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
			if (b[0][0] == 'O') {
				System.out.println("Player 1 wins!");
				return false;
			}
			if (b[0][0] == 'X') {
				System.out.println("Player 2 wins!");
				return false;
			}
		}
		return true;

	}

	boolean checkSecondDiagonal(char[][] b) {

		if (b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
			if (b[1][1] == 'O') {
				System.out.println("Player 1 wins!");
				return false;
			}
			if (b[1][1] == 'X') {
				System.out.println("Player 2 wins!");
				return false;
			}
		}

		return true;

	}

}
