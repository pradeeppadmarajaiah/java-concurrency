package com.basics.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Check if the given number is palindrome or not using Future task
 * 
 * @author pradeep
 *
 */
public class FutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<Boolean> isPalindrome = executorService.submit(new Palindrome("Pradeep"));
		System.out.println("Is Pradeep a Palindrome ?? : " + isPalindrome.get());

		Future<Boolean> isPalindrome1 = executorService.submit(new Palindrome("MALAYALAM"));
		System.out.println("Is MALAYALAM a Palindrome ?? : " + isPalindrome1.get());

		Future<Boolean> isPalindrome2 = executorService.submit(new Palindrome("DeD"));
		System.out.println("Is DED a Palindrome ?? : " + isPalindrome2.get());

		executorService.shutdown();
	}
}

/**
 * 
 * @author pradeep
 *
 */
class Palindrome implements Callable<Boolean> {

	private String value;

	public Palindrome(String value) {
		super();
		this.value = value;
	}

	public Boolean isPalindrome() throws InterruptedException {
		int firstIndex = 0;
		int lastIndex = value.length();
		while (firstIndex < lastIndex && value.charAt(firstIndex) == value.charAt(firstIndex)) {
			firstIndex++;
			lastIndex--;
			Thread.sleep(1000);
		}
		if (firstIndex > lastIndex) {
			return true;
		} else
			return false;
	}

	@Override
	public Boolean call() throws Exception {
		return isPalindrome();

	}

}