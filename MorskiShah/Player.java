
public class Player {
	int number;
	char symbol;

	Player(int number, char symbol) {
		this.number = number;
		this.symbol = symbol;
	}

	void fillBoard(Board b, int row, int col) {
		b.board[row][col] = this.symbol;
	}
	
	void printMove (Board b){
		for (int row=0; row<3; row++){
			for (int col=0; col<3; col++){
				System.out.print(b.board[row][col]+" ");
			}
			System.out.println();
		}
	}

}
