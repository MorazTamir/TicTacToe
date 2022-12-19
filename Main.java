package TicTac;

import TicTac.Game.PlayerType;

public class Main {
	public static void main(String[] args) {
    char[][] arr = new char[3][3];
	int i;
	    char boxNumber = '1';
	    for (i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            arr[i][j] = boxNumber++;
	        }
	    }	
	    for (i = 0; i < arr.length; i++) {
	        for (int j = 0; j < arr[0].length; j++) {
	            System.out.print(" " + arr[i][j] + " ");
	            if(j != arr.length-1){
	            	System.out.print('|');
	            }
	        }
	        System.out.println("");
	
	        if(i != arr.length-1)
	            for (int j = 0; j < 11; j++) {
	            	System.out.print("-");
	            }
	        System.out.println("");
	    }
	}
//	System.out.println(" ----+---+----");
//	for ( i = 0 ; i < 3 ; i++) {
//		System.out.print(" | ");
//		for (int j = 0 ; j < 3 ; j++) {
//			System.out.print("?");
//			System.out.print(" | ");
//		}
//		System.out.println("\n ----+---+----");
//	}
//	}
}

