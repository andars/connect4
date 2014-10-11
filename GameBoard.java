import java.util.*;

public class GameBoard{
    int board[][];
    public GameBoard() {
        this(7,6);
    }
    public GameBoard(int width, int height) {
        board = new int[height][width];
    }
    public GameBoard clone(){
        GameBoard gb = new GameBoard(board[0].length, board.length);
        gb.board = copy(board);
        return gb;
    }
    public int getWidth() {
        return board[0].length;
    }
    public int getHeight() {
        return board.length;
    }
    
    public int getLocation(int row, int col) {
        return board[row][col];
    }
    
    public void setLocation(int row, int col, int value) {
        board[row][col] = value;
    }
    
    public boolean dropDisc(int col, int player) {
        for (int row = board.length-1; row >= 0; row--) {
            if (board[row][col] == 0) {
                setLocation(row, col, player+1);
				return true;
            }
        }
        return false;
    }
    
    public int checkWin() {
        for (int row = 0; row<board.length; row++) {
            for (int col = 0; col<board[0].length; col++) {
                //System.out.println("row: " + row + " col: " + col);
                int player = board[row][col];
                if (player ==  0) {
                	continue;
                }
                if (row+3 < board.length && board[row+1][col] == player && board[row+2][col] == player && board[row+3][col] == player) return player-1;
                if (col+3 < board[0].length && board[row][col+1] == player && board[row][col+2] == player && board[row][col+3] == player) return player-1;
                if ((row+3 < board.length && col+3 < board[0].length)
                    && board[row+1][col+1] == player && board[row+2][col+2] == player && board[row+3][col+3] == player) return player-1;
                if ((row-3 > 0 && col+3 < board[0].length)
                    && board[row-1][col+1] == player && board[row-2][col+2] == player && board[row-3][col+3] == player) return player-1;
            }
        }
        return -1;
    }
    
    public int[][] copy(int[][] src) {
      int dest[][] = new int[src.length][];
      for (int i=0; i <src.length; i++) {
        dest[i] = Arrays.copyOf(src[i], src[i].length);
      }
      return dest;
}
}
