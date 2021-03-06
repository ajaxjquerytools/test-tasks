package net.jcip.examples;


/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 * 
 * @author Brian Goetz and Tim Peierls
 */

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	private static class ReaderRunnable implements Runnable {

		@Override
		public void run() {
			while (!ready)
				Thread.yield();
			System.out.println(number);

		}

	}

	public static void main(String[] args) {
		new Thread(new ReaderRunnable()).run();
		number = 42;
		ready = true;
	}
}
