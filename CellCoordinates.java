package TicTac;

public class CellCoordinates {

	final private int COL;
	final private int ROW;

	public int getCol() {
		return COL;
	}

	public int getRow() {
		return ROW;
	}

	public CellCoordinates(int row, int col) {
		COL = col;
		ROW = row;
	}
}

