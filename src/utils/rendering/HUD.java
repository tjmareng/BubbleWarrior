package src.utils.rendering;

import java.awt.Color;
import java.awt.Graphics;

import src.Main;

public class HUD {

	public static int HEALTH = 100;

	public HUD() {

	}

	public void tick() {
		HEALTH = Main.clamp(HEALTH, 0, 100);
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.GREEN);
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.WHITE);
		g.drawRect(15, 15, 200, 32);
	}
}
