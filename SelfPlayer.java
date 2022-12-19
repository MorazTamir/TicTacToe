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
	
	public SelfPlayer(PlayerType player, SelfGame game) {
		super(player);
		this.game = game;
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(500);
				if (this.player == game.getTurn())
					if(!game.isFullBoard()) {
						ArrayList<CellCoordinates> emptyCell = game.getFreeCells();
						int i = rand.nextInt(emptyCell.size());
						game.setCell(this.player, emptyCell.get(i).getRow(), emptyCell.get(i).getCol());
						game.printBoard();
					}else {
						System.out.println("~Board is FULL~");
						return;
					}
				if (game.isFullBoard()) 
					return;
				}catch (InterruptedException e) {
					return;
				}
			}
		}
	}
