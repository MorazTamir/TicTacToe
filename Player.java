//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import TicTac.Game.PlayerType;

public abstract class Player implements Runnable{
	private PlayerType playerT;
	protected Game game;
	
	public Player (PlayerType player) {
		this.setPlayerT(player);
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public PlayerType getPlayerT() {
		return playerT;
	}

	public void setPlayerT(PlayerType playerT) {
		this.playerT = playerT;
	}	
}
