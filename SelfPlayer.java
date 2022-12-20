//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.ArrayList;
import java.util.Random;

import TicTac.Game.PlayerType;

public class SelfPlayer extends Player {
	Random rand = new Random ();
	PlayerType player;
	SelfGame game;
	
	public SelfPlayer(PlayerType player) {
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
                        if (game.GameOver())
                            break;
                    }
                } catch (InterruptedException e) {
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            synchronized (game) {
                if (!game.GameOver()) {
                    ArrayList<CellCoordinates> cellsFree = game.getFreeCells();
                    //Save the empty cells using in the Game class
                    int index = (int) (Math.random() * cellsFree.size());
                    game.makeMove(cellsFree.get(index));
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
