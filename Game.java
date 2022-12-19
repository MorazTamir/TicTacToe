package TicTac;

public abstract class Game {
	private static int round =0;
	enum PlayerType {
		FREE,
		X,
		O
	}
	private PlayerType [][] gameBoard;
	private PlayerType turn;
	
	public Game() {
		gameBoard = new PlayerType [3][3];
		resetBord(); //Update the board for free in the start - clean.
		round++;
	}//constractor for the board

	public void printBoard() {
		System.out.println("_____________");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.println("|");
			for (int j = 0 ; j < 3 ; j++) {
				if (gameBoard[i][j] == PlayerType.FREE)
					System.out.println("?");
				else if (gameBoard[i][j] == PlayerType.X)
					System.out.println("X");
				else if (gameBoard[i][j] == PlayerType.O)
					System.out.println("O");
			}
		}
	}

	public void getTurn() {
		//use enum Turn
		
	}//Return who should play now
	
	public void getFreeCells() {
		
	}// Returns empty cells according to coordinates
}
