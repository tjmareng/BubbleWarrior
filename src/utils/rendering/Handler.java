package src.utils.rendering;

import java.awt.Graphics;
import java.util.LinkedList;

import src.utils.objects.GameObject;

public class Handler {

	private LinkedList<GameObject> list = new LinkedList<GameObject>();

	public Handler() {

	}

	public void tick() {
		for (int i = 0; i < getList().size(); i++) {
			GameObject tempObject = getList().get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < getList().size(); i++) {
			GameObject tempObject = getList().get(i);

			tempObject.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.getList().add(object);
	}

	public void removeObject(GameObject object) {
		this.getList().remove(object);
	}

	public LinkedList<GameObject> getList() {
		return list;
	}

	public void setList(LinkedList<GameObject> list) {
		this.list = list;
	}

	// Game Objects
}
