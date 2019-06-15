package utils.threads;

public class IDManager {

	private int _ID;

	public IDManager(int ID) {
		this._ID = ID;
	}

	public int next() {
		return _ID++;
	}

	public int getCurrentID() {
		return _ID;
	}
}
