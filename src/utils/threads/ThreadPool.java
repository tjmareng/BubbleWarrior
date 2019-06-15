package utils.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPool extends ThreadGroup {

	private static IDManager ID = new IDManager(0);

	private boolean running;
	private List<Runnable> taskQueue;
	private int _ID;

	public ThreadPool(int threadsToRun) {

		super("Thread Pool - " + ID.next());
		this._ID = ID.getCurrentID();
		setDaemon(true);
		taskQueue = new LinkedList<Runnable>();

		while (threadsToRun != 0) {
			new Pool(this).start();
			threadsToRun--;
		}
		running = true;
	}

	public synchronized void runTask(Runnable task) {

		if (!running) {
			throw new IllegalStateException("Thread Pool - " + _ID + " is no longer running");
		}

		if (task != null) {
			taskQueue.add(task);
			notify();
		}
	}

	public synchronized void close() {
		if (!running) {
			return;
		}

		running = false;
		taskQueue.clear();
		interrupt();
	}

	public void join() {

		synchronized (this) {
			running = false;
			notifyAll();
		}

		Thread[] activeThreads = new Thread[activeCount()];

		for (Thread thread : activeThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				Logger.getLogger(ThreadPool.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	protected synchronized Runnable getTask() throws InterruptedException {

		while (taskQueue.isEmpty()) {
			if (!running) {
				return null;
			}
			wait();
		}
		return taskQueue.remove(0);
	}

}
