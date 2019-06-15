package src.utils.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Pool extends Thread {

	private static IDManager _threadID = new IDManager(0);
	private ThreadPool _pool;

	public Pool(ThreadPool pool) {
		super(pool, "Pooled Thread - " + _threadID.next());
		this._pool = pool;
	}

	@Override
	public void run() {
		while (!isInterrupted()) {
			Runnable task = null;

			try {
				task = _pool.getTask();
			} catch (InterruptedException e) {
				Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, e);
			}

			if (task == null) {
				return;
			}

			try {
				task.run();
			} catch (Throwable t) {
				_pool.uncaughtException(this, t);
			}
		}
	}
}
