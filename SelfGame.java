package TicTac;
import java.util.ArrayList;

public class SelfGame extends Game {
	boolean playerTurn;
	
	public SelfGame(){
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
}
