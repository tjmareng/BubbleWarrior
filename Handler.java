import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> list = new LinkedList<GameObject>();

	public Handler() {

	}

	public void tick() {
		for (int i = 0; i < list.size(); i++) {
			GameObject tempObject = list.get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < list.size(); i++) {
			GameObject tempObject = list.get(i);

			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.list.add(object);
	}

	public void removeObject(GameObject object) {
		this.list.remove(object);
	}

	// Game Objects
}
