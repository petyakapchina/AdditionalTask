import java.util.Scanner;

public class HorseMove {
	static void horseMove (char [][] b, int row, int col){
		if (row < 0 || row >= b.length){
			return;
		}
		if (col < 0 || col >= b[0].length){
			return;
		}
		if (b[row][col]!='-'){
			return;
		}

		
		b[row][col]='x';
		
		horseMove(b,row-2, col-1);
		horseMove(b,row-2, col+1);
		horseMove(b,row+2, col-1);
		horseMove(b,row+2, col+1);
		horseMove(b,row-1, col-2);
		horseMove(b,row-1, col-2);
		horseMove(b,row+1, col-2);
		horseMove(b,row+1, col+2);
		}
	
	static void printBoard (char [][] b){
		for (int index=0; index<b.length; index++){
			for (int index1=0; index1<b[0].length; index1++){
				System.out.print(b [index][index1]+" ");
			}
			System.out.println();
		} 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the number of rows of the board: ");
		int boardRows = sc.nextInt();
		System.out.println("Enter the number of columns of the board: ");
		int boardCols = sc.nextInt();
		
		if ((boardRows<2 && boardCols<4)||(boardRows<4 && boardCols<2)){
			System.out.println("Too small coordinates.");
			System.out.println("Please, enter values bigger than 2x4!");
		}
		
		char [][] board = new char [boardRows][boardCols];
		
		System.out.println("Enter your position: Row: ");
		int playerRow = sc.nextInt();
		System.out.println("Enter your position: Column:");
		int playerCol = sc.nextInt();
		
		if (playerRow>boardRows || playerCol>boardCols){
			System.out.println("Invalid range!");
			}
		
		for (int index=0; index<board.length; index++){
			for (int index1=0; index1<board[0].length; index1++){
				board [index][index1]='-';
			}
		}
		horseMove(board, playerRow-1, playerCol-1);
		printBoard(board);
			
sc.close();
		
	}

}
