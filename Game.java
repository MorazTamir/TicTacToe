package TicTac;

import java.security.InvalidParameterException;
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
	}//Constructor for the board

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
	
	
}
