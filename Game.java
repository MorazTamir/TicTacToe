//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Game {
	enum PlayerType {
		FREE,
		X,
		O
	}
	protected PlayerType [][] gameBoard;
	protected PlayerType turn;
	
	public Game() {
		gameBoard = new PlayerType [3][3];
		resetBord(); //Update the board for free in the start - clean.
	}//Constructor for the board
	
	/*
	 * 	[0][0] , [0][1] , [0][2]
	 * 	[1][0] , [1][1] , [1][2]
	 * 	[2][0] , [2][1] , [2][2]
	 */

	public synchronized void printBoard() {
		System.out.println(" ----+---+----");
		for (int i = 0 ; i < 3 ; i++) {
			System.out.print(" | ");
			for (int j = 0 ; j < 3 ; j++) {
				if (gameBoard[i][j] == PlayerType.FREE)
					System.out.print("?");
				else if (gameBoard[i][j] == PlayerType.X)
					System.out.print("X");
				else if (gameBoard[i][j] == PlayerType.O)
					System.out.print("O");
				else 
					System.out.println(gameBoard[i][j]);
				System.out.print(" | ");
			}
			System.out.print("\n ----+---+----");
		}
	}
	public void resetBord() {
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++ )
				gameBoard[i][j] = PlayerType.FREE; //init (start)
		}
		this.turn = PlayerType.X; //the first that play
	}
        
/*	public synchronized PlayerType getTurn() {
		//use enum Turn
		if (PlayerType.O != null)
            return PlayerType.X;
        return PlayerType.O;	
       }//Returns the type of player it turns to play
*/
	public  PlayerType getTurn() {
		//use enum Turn	
		return turn;
	}//Returns the type of player it turns to play
	
	public ArrayList <CellCoordinates> getFreeCells() {
		ArrayList <CellCoordinates> ans = new ArrayList <CellCoordinates> ();
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if (gameBoard[i][j] == PlayerType.FREE)
					ans.add(new CellCoordinates(i,j) );
			}
		}
		return ans;
	}// Returns empty cells according to coordinates in list.
	
	public boolean isFullBoard() {
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if (gameBoard[i][j] == PlayerType.FREE)
					return false;
			}
		}
		return true;
	} //Check if the board full
	
	//Setter and getters
	
	public void setCell(PlayerType type , int row , int col) {
		if (row>=0 && row<3 && col>=0 && col<3) {
			if (gameBoard[row][col] == PlayerType.FREE) {
				gameBoard[row][col] = type;
				if (type == PlayerType.X)
					turn = PlayerType.O; 
				else
					turn = PlayerType.X;
			}else 
				throw new InvalidParameterException("The player tried to insert in a occupied cell - not empty place");
		}else
			throw new InvalidParameterException("Wrong index");
	}// set the state cell, and update player game.
		
	public PlayerType getCell(int row, int col) {
		if (row>=0 && row<3 && col>=0 && col<3) 
			return gameBoard[row][col];
			throw new InvalidParameterException("Wrong index");
	}//Getting the cell status
	
	public boolean isWon(PlayerType sign) {
		//check rows
		for (int i=0; i<3; i++) {
			if ( gameBoard[i][0] != PlayerType.FREE &&
					gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][3]) {
				System.out.println(getCell(0,i) + " WIN!");
				return true;
			}
			
				//check col
			else if ( gameBoard[0][i] != PlayerType.FREE &&
					gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[3][i]) {
				System.out.println(getCell(0,i) + " WIN!");
				return true;
			}
		}
		//diagonal
		if(gameBoard[1][1] != PlayerType.FREE && ((gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) 
				||(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0])) ) {
			System.out.println(getCell(1,1) + " WIN!");
			return true;
			
		}
		return false;
	}
	
	//game is over when type win or board full
	public boolean GameOver() {
    	if ( isFullBoard() || isWon(PlayerType.X) || isWon(PlayerType.O) )
    		return true;
    	return false;
	}
	
	//Check who won
	public PlayerType getWinner() {
        if (isWon(PlayerType.X))
            return PlayerType.X;
        else if (isWon(PlayerType.O))
            return PlayerType.O;
        else
            return null;
    }
	
	public void makeMove(CellCoordinates cell) {
		if (gameBoard[cell.getRow()][cell.getCol()] == PlayerType.FREE) {
			gameBoard[cell.getRow()][cell.getCol()] = turn;
				if( turn == PlayerType.X )
					turn = PlayerType.O ;
				else 
					turn = PlayerType.X;
			printBoard();
			System.out.println();
		} else {
	            System.out.println("This cell is already taken!");
		}
	}
}


