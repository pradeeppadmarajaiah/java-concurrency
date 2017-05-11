package com.basics.creation;

import java.util.EnumSet;

/**
 * Print all the states of the Threads
 * 
 * @author pradeep
 *
 */
public class ThreadState {
	public static void main(String[] args) {

		for (Thread.State state : EnumSet.allOf(Thread.State.class)) {
			System.out.println(state);
		}
	}

}
