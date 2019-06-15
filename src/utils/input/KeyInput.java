package src.utils.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import src.utils.objects.GameObject;
import src.utils.objects.ID;
import src.utils.rendering.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.getList().size(); i++) {
			GameObject tempObject = handler.getList().get(i);

			if (tempObject.getID() == ID.Player) {
				// key events for player 1

				if (key == KeyEvent.VK_W) {
					tempObject.setVelY(-5);
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setVelX(-5);
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setVelY(5);
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setVelX(5);
				}
			}

		}

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.getList().size(); i++) {
			GameObject tempObject = handler.getList().get(i);

			if (tempObject.getID() == ID.Player) {
				// key events for player 1

				if (key == KeyEvent.VK_W) {
					tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setVelX(0);
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setVelY(0);
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setVelX(0);
				}
			}

		}
	}

}
