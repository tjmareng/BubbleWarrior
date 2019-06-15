package src.utils.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTest implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread started");
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			Logger.getLogger(ThreadTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Thread ended");
	}

}
