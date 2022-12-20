//Author1: Ninel Benush 324699826
//Author2: Moraz Tamir 208397455

package TicTac;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter: 1 - User VS Comp\n"
						 + "       2- Comp VS Comp ");
		int choice = in.nextInt();
		switch(choice) {
		  case 1:
			  UserGame userGame = new UserGame();
		      userGame.start();
		    break;
		  case 2:
			  SelfGame selfGame = new SelfGame();
			  selfGame.start();
		    break;	
		}
		
		in.close();
	}

}

