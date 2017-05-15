package com.basics.creation;

public class ThreadInterrupt implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Entering run() with Thread : " + Thread.currentThread());
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(120);
				Thread.currentThread();

				System.out.println("Count : " + i);
			} catch (InterruptedException e) {

				System.out.println("Thread is interrupted");

			}

		}
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		Thread sampleThreadInterrupt = new Thread(new ThreadInterrupt());
		sampleThreadInterrupt.start();

		sampleThreadInterrupt.interrupt();

	}

}
