package src.utils.objects;

import java.awt.Color;
import java.awt.Graphics;

import src.Main;
import src.utils.objects.*;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub

		velX = 5;
		velY = 5;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

		x += velX;
		y += velY;

		if (x <= 0 || x > Main.WIDTH - 32) {
			velX *= -1;
		}
		if (y <= 0 || y > Main.HEIGHT - 40) {
			velY *= -1;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.RED);
		g.fillRect(x, y, 16, 16);
	}

}
