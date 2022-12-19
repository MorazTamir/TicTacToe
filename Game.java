package TicTac;

import java.util.ArrayList;

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

	public synchronized void printBoard() {
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
				else 
					System.out.println(gameBoard[i][j]);
				System.out.println("|");
			}
			System.out.println("_____________");
		}
	}
	public void resetBord() {
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++ )
				gameBoard[i][j] = PlayerType.FREE; //init (start)
		}
		turn = PlayerType.X; //the first that play
	}
        
	public synchronized PlayerType getTurn() {
		//use enum Turn
		if (PlayerType.O != null)
            return PlayerType.X;
        return PlayerType.O;	
        //return turn;
       }//Returns the type of player it turns to play
	
	public ArrayList <CellCoordinates> getFreeCells() {
		
		
	}// Returns empty cells according to coordinates in list.
}
