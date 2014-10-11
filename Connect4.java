import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Connect4 extends JPanel implements MouseListener {
	
	int player = 0;
	int cols = 7;
	int rows = 6;
	int size = 80;
	GameBoard board = new GameBoard(cols, rows);
	C4Minimax ai = new C4Minimax(0);	
	public Connect4() {
		addMouseListener(this);
		int move = ai.getBestMove(board);
		board.dropDisc(move, (player+1)%2);
	
	}
	public void paint(Graphics g) {
		g.translate(20,20);
		drawBoard(g);
		g.translate(0,0);
	}
	public void drawBoard(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(-10,-10, size*cols + 20, size*rows + 20);
		for (int row = 0; row < board.getHeight(); row++) {
			for (int col = 0; col < board.getWidth(); col++) {

				if (board.getLocation(row,col) == 1) {
					g.setColor(Color.red);
				} else if (board.getLocation(row, col) == 2) {
					g.setColor(Color.black);
				} else {
					g.setColor(Color.white);
				}
				g.fillOval(col*size, row*size, size, size);
			}
		}
	}
	public void mouseEntered(MouseEvent e){	
	}
	public void mouseExited(MouseEvent e){	
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){	
	}
	public void mouseClicked(MouseEvent e){
	    System.out.println("click");
		int x = e.getX()-20;
		int col = x/80;
		board.dropDisc(col, player);
		repaint();
		int move = ai.getBestMove(board);
		board.dropDisc(move, (player+1)%2);

		//player = (player+1)%2;
		int s = board.checkWin();
		if (s >= 0) {
			System.out.println("won: " + board.checkWin());
			removeMouseListener(this);
		}

		repaint();
	}
}
