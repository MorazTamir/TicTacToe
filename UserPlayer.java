//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.Scanner;

import TicTac.Game.PlayerType;

public class UserPlayer extends Player{
	PlayerType player;
	UserGame game;

	public UserPlayer(PlayerType player) {
		super(player);
	}

	
	public void run() {
		if (game == null) {
			throw new IllegalStateException("Game is not set!");
		}
		chooseCell();
	}
	public void chooseCell() {
	        while (true) {
	            while (game.getTurn() != getPlayerT()) {
	                try {
	                    synchronized (game) {
	                        game.wait();
	                        if (game.GameOver()) {
	                            break;
	                        }
	                    }
	                } catch (InterruptedException e) {
	                }
	            }

	            synchronized (game) {
	                if (!game.GameOver()) {
						Scanner in = new Scanner(System.in);
	                    game.printBoard();
	                    System.out.println("Your turn! Enter the cell: ");
	                    int cell = in.nextInt() - 1;
	                    int row = cell / 3;
	                    int col = cell % 3;
	                    game.makeMove(new CellCoordinates(row, col));
	                    in.close();
	                } else {
	                    // End the game and notify the other player
	                    game.notifyAll();
	                    break;
	                }

	                game.notifyAll();
	            }
	        }
	    }
}

