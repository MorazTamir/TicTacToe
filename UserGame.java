//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.ArrayList;

public class UserGame extends Game {
boolean playerTurn;
	
	public UserGame(){
		playerTurn = true;
	} //his turn
	
	public synchronized void printBoard() {
		super.printBoard();
	}
	
	public void resetBord() {
		super.resetBord();
	}

	public synchronized PlayerType getTurn() {
		return super.getTurn();
	}

	public ArrayList<CellCoordinates> getFreeCells() {
		return super.getFreeCells();
	}

	public boolean isFullBoard() {
		return super.isFullBoard();
	}

	public synchronized void setCell(PlayerType type, int row, int col) {
		try {
		while (type != getTurn())
			wait();
		}catch (InterruptedException e) {
			return;
		}
			super.setCell(type, row, col);
			printBoard();
	}

	public PlayerType getCell(int row, int col) {
		return super.getCell(row, col);
	}
	
	// check if won
	public synchronized void checkIfWon(){
		//check rows
		for (int i=0; i<3; i++) {
			if ( gameBoard[i][0] != PlayerType.FREE &&
					gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][3]) {
	            System.out.println(getCell(0,i) + " WIN!");
				gameOver = true;
			}
		}
		
		//check col
		for (int i=0; i<3; i++) {
			if ( gameBoard[0][i] != PlayerType.FREE &&
					gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[3][i]) {
	            System.out.println(getCell(0,i) + " WIN!");
				gameOver = true;
			}
		}
		
		//diagonal
        if(gameBoard[1][1] != PlayerType.FREE && ((gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]) 
        		||(gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0])) ) {
            System.out.println(getCell(1,1) + " WIN!");
            gameOver = true;

        }
	}
	
}
