package de.syrocon.jse10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoreAPIDemo {

	public static void main(String[] args) {
		System.out.println("Show local type inference:");
		showLocalTypeInference();

		System.out.println("\nShow unmodifiable list:");
		showUnmodifiableList();

		System.out.println("\nShow optional throw:");
		showOptionalThrow();
	}

	@SuppressWarnings("unused")
	private static void showLocalTypeInference() {
		var zahl = 5; // int
		var flag = true; // boolean
		var text = "Hello World"; // String
		System.out.println(text instanceof String);
		String var;
		zahl = 1; // zahl = 1.5 results in compile error
		
		var numbers = Arrays.asList(1, 2, 3); // List<Integer>
		for (var number: numbers) { // Integer
			System.out.println(number instanceof Integer);
		    System.out.println(number);
		}
		
		var factor = 2; // effectively final
		numbers = List.of(2, 16, 4, 12, 38, 15, 1);
		numbers.stream().forEach(v -> System.out.println(v * factor)); // final variable can be used in lambda expression
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
			System.out.println("Hello World!");
		}
	}

}
