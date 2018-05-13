package de.syrocon.jse10;

import java.util.List;
import java.util.stream.Collectors;

public class CoreAPIDemo {

	public static void main(String[] args) {
		System.out.println("Show unmodifiable list:");
		showUnmodifiableList();

		System.out.println("\nShow optional throw:");
		showOptionalThrow();
	}

	private static void showUnmodifiableList() {
		List<Integer> numbers = List.of(2, 16, 4, 12, 38, 15, 1);
		List<Integer> singleDigits = numbers.stream().filter(v -> v < 10).collect(Collectors.toUnmodifiableList());
		singleDigits.forEach(System.out::println);
	}

	@SuppressWarnings("unused")
	private static void showOptionalThrow() {
		List<Integer> numbers = List.of(2, 16, 4, 12, 38, 15, 1);
		try {
			Integer empty = numbers.stream().filter(v -> v < 0).findFirst().orElseThrow(); // throws java.util.NoSuchElementException
		} catch (java.util.NoSuchElementException e) {
			System.out.println("No element in filtered stream");
		}
	}
}
