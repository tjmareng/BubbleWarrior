package utils.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import src.Main;

public class Player extends GameObject {

	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);

		velX = 0;
		velY = 0;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;

		x = Main.clamp(x, 0, Main.WIDTH - 32);
		y = Main.clamp(y, 0, Main.HEIGHT - 32);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (id == ID.Player) {
			g.setColor(Color.white);
		}
		g.fillRect(x, y, 32, 32);
	}

}
