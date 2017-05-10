package com.basics.creation;

/**
 * @class ThreadTypes
 * @brief This class explains the different types of threads in java.
 * @author pradeep
 *
 */
public class ThreadTypes {

	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		Thread userThread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(130);
					System.out.println("User Thread : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		System.out.println("Is daemon thread : " + userThread.isDaemon());

		// Program terminates once all user thread finishes it’s task without
		// waiting for the daemon threads.
		Thread deamonThread = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				try {
					Thread.sleep(130);
					System.out.println("Deamon Thread : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		deamonThread.setDaemon(true);
		System.out.println("Is daemon thread : " + deamonThread.isDaemon());

		userThread.start();

		deamonThread.start();

	}

}
