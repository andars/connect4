public class MinimaxTest {
	public static void main(String[] args) {
		GameBoard gb = new GameBoard();
		gb.dropDisc(0, 1);
		gb.dropDisc(1, 1);
		gb.dropDisc(2, 1);
		C4Minimax ai = new C4Minimax(1);
		System.out.println(ai.getBestMove(gb));
	}
}
