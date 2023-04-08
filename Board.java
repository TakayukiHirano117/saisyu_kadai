package saisyu_kadai;

public class Board {
	
	// ゲームが継続しているかどうかを示すフラグ
	static boolean game = true;
	
	// オセロ版を表す多次元配列
	static String[][] board = new String[8][8];
	
	static String empty = " ";
	static String black = "●";
	static String white = "○";
	
	static String stone;
	static String rev_stone;
	
	// オセロ板の要素を初期化する
	public static void initializeBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = empty;
			}
		}
		board[3][3] = black;
		board[3][4] = white;
		board[4][3] = white;
		board[4][4] = black;
		
		// 先手は黒、後手は白
		stone = black;
		rev_stone = white;
		
		game = true;
	}
	
	public static void displayBoard() {
		// 列番号と行間を見やすくする区切り線
		System.out.println("⋱|0|1|2|3|4|5|6|7|");
		System.out.println("――――――――――――――――――");
		
		// 空のマスがあるか、黒と白の石のカウント
		boolean is_empty = false;
		int cBlack = 0;
		int cWhite = 0;
		
		// 行番号を振るためのインデックスi
		int i = 0;
		
		for(String[] array : board) {
			System.out.print(i + "|");
			for(String s : array) {
				System.out.print(s);
				System.out.print("|");
				
				if(s.equals(empty)) {
					is_empty = true;
				} else if(s.equals(black)) {
					cBlack++;
				} else if(s.equals(white)) {
					cWhite++;
				}
				
			}
			
			System.out.println();
			System.out.println("――――――――――――――――――");
			i++;
		}
		
		System.out.println(black + ":" + cBlack);
		System.out.println(white + ":" + cWhite);
		System.out.println("――――――――――――――――――");
		
		if(is_empty) {
			System.out.println(stone + "のターンです。");
		} else {
			System.out.println("ゲーム終了");
			game = false;
		}
		
	}
	
	public static void setStone(int x, int y) {
		// オセロ版の中の座標を指定した場合
		if(board[y][x].equals(empty)) {
			board[y][x] = stone;
			
			turnStone(x, y);
			
			String next_rev_stone = stone;
			stone = rev_stone;
			rev_stone = next_rev_stone;
			
			displayBoard();
			
			// オセロ版の外の座標を指定した時
		} else if(x > 7 || y > 7) {
			System.out.println("そこに石を置くことはできません");
		} else {
			System.out.println("そこに石を置くことはできません");
		}
		
	}
	
	// 上下左右斜めの8方向を調べて石をひっくり返す
	public static void turnStone(int x, int y) {
		turnUpper(x, y);
		turnUpperRight(x, y);
		turnRight(x, y);
		turnLowerRight(x, y);
		turnLower(x, y);
		turnLowerLeft(x, y);
		turnLeft(x, y);
		turnUpperLeft(x, y);
	}
	
	// 真上の石をひっくり返す
	public static void turnUpper(int x, int y) {
		
		if(y > 1) {
			// 隣の石
			String next = board[y - 1][x];
			
			// 隣の石が自分が置いた石と別の色の時
			if(next.equals(rev_stone)) {
				for(int i = 2; true; i++) {
					if(y - i < 0 || board[y - i][x].equals(empty)) {
						break;
					} else if(board[y - i][x].equals(stone)) {
						// 石の色が同じとき
						// 2つの石の間にある石をひっくり返す
						for(int j = 0; j < i; j++) {
							board[y - j][x] = stone;
						}
						break;
					}
				}
			}
		}
		
	}
	
	// 右上の石をひっくり返す
	public static void turnUpperRight(int x, int y) {
		
		if(x < 6 && y > 1) {
			String next = board[y - 1][x + 1];
			
			// 隣の石が置いた石と別の色の時
			if(next.equals(rev_stone)) {
				for(int i = 2; true; i++) {
					if(x + i > 7 || y - i < 0 || board[y - i][x + i].equals(empty)) {
						break;
					} else if(board[y - i][x + i].equals(stone)) {
						// 石の色が同じとき
						// 2つの石の間にある石をひっくり返す
						for(int j = 1; j < i; j++) {
							board[y - i][x + i] = stone;
						}
						break;
					}
				}
			}
		}
		
	}
	
	// 右の石をひっくり返す
	public static void turnRight(int x, int y) {
		
	}
	
	// 右下の石をひっくり返す
	public static void turnLowerRight(int x, int y) {
		
	}
	
	// 下の石をひっくり返す
	public static void turnLower(int x, int y) {
		
	}
	
	// 左下の石をひっくり返す
	public static void turnLowerLeft(int x, int y) {
		
	}
	
	// 左の石をひっくり返す
	public static void turnLeft(int x, int y) {
		
	}
	
	// 左上の石をひっくり返す
	public static void turnUpperLeft(int x, int y) {
			
  }
