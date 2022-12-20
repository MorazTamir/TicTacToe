//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.ArrayList;

public class SelfGame extends Game {
	SelfPlayer player1= new SelfPlayer(PlayerType.X);
    SelfPlayer player2 = new SelfPlayer(PlayerType.O);  
    
    public void start() {
    	player1.setGame(this);
        player2.setGame(this);
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        thread1.start();
        thread2.start();
        resetBord();
    	printBoard();
    	System.out.println("Start game!");
        try {
            thread1.join();
            thread2.join();

            if(isFullBoard()) {
            	System.out.println("Winner: " + getWinner());
                
            } else {
                System.out.println("Choose cell");
            }
        } catch (InterruptedException e) {
        	return;     
        }
    }
	
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
