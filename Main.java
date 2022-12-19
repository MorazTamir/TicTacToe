//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.Scanner;
import TicTac.Game.PlayerType;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter: 1 - User VS Comp\n"
						 + "       2- Comp VS Comp ");
		int choice = in.nextInt();
		switch(choice) {
		  case 1:
		    
		    break;
		  case 2:
			  SelfGame theGame = new SelfGame();
			  SelfPlayer p1 = new SelfPlayer(PlayerType.X, theGame);
			  SelfPlayer p2 = new SelfPlayer(PlayerType.O, theGame);
			  System.out.println("Start:");
			  Thread t1 = new Thread (p1);
			  Thread t2 = new Thread (p2);
			  t1.start();
			  t2.start();
		    break;	
		}
		
		in.close();
	}

}

