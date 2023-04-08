package saisyu_kadai;

import java.util.Scanner;

public class Othello {
	public static void main(String args[]) {
		
		Board.initializeBoard();
		Board.displayBoard();
		
		Scanner s = new Scanner(System.in);
		
		while(Board.game) {
			
			System.out.println("石を置くx座標を指定してください");
			int x = s.nextInt();
			
			System.out.println("石を置くy座標を指定してください");
			int y = s.nextInt();
			
			Board.setStone(x, y);
			
		}
		
		s.close();
		
	}
}
