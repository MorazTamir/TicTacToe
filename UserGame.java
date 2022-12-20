//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.ArrayList;

import TicTac.Game.PlayerType;

public class UserGame extends Game {
	SelfPlayer player1;
    UserPlayer player2; 
	
	public UserGame(){
		SelfPlayer player1 = new SelfPlayer(PlayerType.X);
		UserPlayer player2 = new UserPlayer(PlayerType.O);	} //his turn
	
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

	
}
