package src;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This class creates the window for the game
 */
public class Window extends Canvas {

	private static final long serialVersionUID = -8255319694373975038L;

	public Window(int width, int height, String title, Main game) {
		JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); // OPTIONAL: allows window resize
		frame.setLocationRelativeTo(null); // OPTIONAL: window begins in center
		frame.add(game);
		frame.setVisible(true);
		game.start(); // Launches game
	}
}
