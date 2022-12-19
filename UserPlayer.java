//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.ArrayList;
import java.util.Scanner;

import TicTac.Game.PlayerType;

public class UserPlayer extends Player{
	PlayerType player;
	UserGame game;

	public UserPlayer(PlayerType player, UserGame game) {
		super(player);
		this.game = game;
	}

	
	public void run() {

		while (true) {
			if (this.player == game.getTurn())
				if(!game.isFullBoard()) {
					Scanner dd = new Scanner(System.in);
					ArrayList<CellCoordinates> emptyCell = game.getFreeCells();
					System.out.print("Enter row 0 to 2 ");
					int iR = dd.nextInt();
					System.out.print("Enter col 0 to 2 ");
					int iC = dd.nextInt();
					if (iR<0 && iR>3 || iC<0 && iC>3) {
						System.out.println("wrong index try again:");
						System.out.print("Enter row 0 to 2 ");
						iR = dd.nextInt();
						System.out.print("Enter col 0 to 2 ");
						iC = dd.nextInt();
					}
					if (game.getCell(iR, iC) == PlayerType.FREE) 
					game.setCell(this.player, emptyCell.get(iR).getRow(), emptyCell.get(iC).getCol());
					game.printBoard();
					dd.close();
				}else {
					System.out.println("~Cell is FULL~");
					return;
				}
			if (game.isFullBoard()) 
				return;

		}

		}
}

