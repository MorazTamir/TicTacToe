//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import TicTac.Game.PlayerType;

public abstract class Player implements Runnable{
	PlayerType player;
	public Player (PlayerType player) {
		this.player = player;
	}
}
