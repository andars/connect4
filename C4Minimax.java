
public class C4Minimax
{
	int player;
	public C4Minimax(int player) {
		this.player = player;
	}
	public int getBestMove(GameBoard state) {
		int results[] = minimax(state, this.player, 8);
		System.out.println(results[0] + " " + results[1]);
		return results[1];
	}
	public int[] minimax(GameBoard state, int player, int depth) {
	//	System.out.println("MINIMAX at depth " + depth + " player: " + player);
		if (gameOver(state) || depth == 0) {
	//		System.out.println("found end state: " + evaluate(state));
				//System.out.println("found end state: " + evaluate(state));
			return new int[]{evaluate(state, depth), 0};
		}
		if (player == this.player) {
			int max = Integer.MIN_VALUE;
			int max_col = 0;
			for (int col = 0; col<state.getWidth(); col++) {
				GameBoard next = state.clone();
				if (!next.dropDisc(col, player)) continue; //only take possible moves
				int val = minimax(next, (player+1)%2, depth-1)[0];
//				System.out.println("testing " + col + ", value = " + val);
				if (val > max) {
					max = val;
					max_col = col;
				}
			}
			//System.out.println("at depth: " + depth + " max is " + max + " at col " + max_col);
			return new int[]{max,max_col};
		} else {
			int min = Integer.MAX_VALUE;
			int min_col = 0;
			for (int col = 0; col<state.getWidth(); col++) {
				GameBoard next = state.clone();
				if (!next.dropDisc(col, player)) continue;
				int val = minimax(next, (player+1)%2, depth-1)[0];
				if (val < min) {
					min = val;
					min_col = col;
				}
			}
			return new int[]{min, min_col};
		}
	}
	private boolean gameOver(GameBoard state) {
		if (state.checkWin() >= 0) {
			return true;
		}
		return false;
	}
	private int evaluate(GameBoard state, int depth) {
		if (state.checkWin() >= 0) {
		//	System.out.println("finding value for terminal " + state.checkWin());
			if (state.checkWin() == this.player) {
		//		System.out.println("WOOOOOT");
				return 100 + depth;
			} else {
				return -100 - depth; 
			}
		}
		//massively awesome heuristic right here
		return (int) (Math.random()*10) - 5; 
	}
}
