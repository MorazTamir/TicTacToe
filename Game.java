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
    public boolean gameOver;

	
	public Game() {
		gameBoard = new PlayerType [3][3];
		resetBord(); //Update the board for free in the start - clean.
		gameOver = false;
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
		gameOver = true;
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

//public static char[][] getClean2DCharArray(int rows, int columns) {
//    char boxNumber = '1';
//    char[][] arr = new char[rows][columns];
//    for (int i = 0; i < rows; i++) {
//        for (int j = 0; j < columns; j++) {
//            arr[i][j] = boxNumber++;
//        }
//    }
//    return arr;
//}
//
///**
// * Print the game matrix
// * @param array The game matrix 2D array
// */
//public static void printMatrix(char[][] array){
//    for (int i = 0; i < array.length; i++) {
//        for (int j = 0; j < array[0].length; j++) {
//            System.out.print(" " + array[i][j] + " ");
//            if(j != array.length-1){
//                printMatrix("|");
//            }
//        }
//        println("");
//
//        if(i != array.length-1)
//            for (int j = 0; j < 11; j++) {
//                printMatrix("-");
//            }
//        println("");
//    }
//}


