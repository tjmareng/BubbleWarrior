package src;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

import src.utils.input.*;
import src.utils.threads.*;
import src.utils.rendering.*;
import src.utils.objects.*;

/**
 * This class is the main class for running the game
 */
public class Main extends Canvas implements Runnable {

	private static final long serialVersionUID = -4701693684670803303L;
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9; // Adjusts window size
	private boolean running = false;
	private ThreadPool _thread;
	private Handler _handler;
	private HUD _hud;
	private Random r;

	public Main() {
		_handler = new Handler();
		this.addKeyListener(new KeyInput(_handler));

		new Window(WIDTH, HEIGHT, "Game", this);

		_hud = new HUD();
		r = new Random();

		_handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, src.utils.objects.ID.Player));
		_handler.addObject(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 2 - 32, src.utils.objects.ID.BasicEnemy));
	}

	public synchronized void start() {
		_thread = new ThreadPool(1); // Single threaded
		_thread.runTask(this);
		// _thread.runTask(new ThreadTest()); // Thread Test
		running = true;
	}

	public synchronized void stop() {
		try {
			_thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running) {
				render();
			}
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		_handler.tick();
		_hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		_handler.render(g);
		_hud.render(g);

		g.dispose();
		bs.show();
	}

	public static int clamp(int var, int min, int max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else {
			return var;
		}

	}

	public static void main(String[] args) {
		new Main();
	}

}
