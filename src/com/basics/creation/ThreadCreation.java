package com.basics.creation;

/**
 * Thread creation extending Thread.
 * 
 * @author pradeep
 *
 */
public class ThreadCreation extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(120);
				System.out.println("Count : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		ThreadCreation sampleThread = new ThreadCreation();
		sampleThread.start();
		sampleThread.join();

		Thread thread1 = new Thread(new SampleThread1());
		thread1.start();
		thread1.join();

		// Run directly //it runs in a main thread not creating a new thread.
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(120);
					System.out.println("Count : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).run();

		// Java 8 syntax
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(120);
					System.out.println("Count : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

}

/**
 * Thread creation using Runnable.
 * 
 * @author pradeep
 *
 */

class SampleThread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(120);
				System.out.println("Counti : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
