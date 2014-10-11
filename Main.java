import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		JPanel game = new Connect4();
		//GameBoard b = new GameBoard();
		//GameBoard copy = b.clone();
		
		frame.add(game);
		frame.setPreferredSize(new Dimension(800,600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
	}
}
