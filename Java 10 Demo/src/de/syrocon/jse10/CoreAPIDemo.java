package de.syrocon.jse10;

import java.util.List;
import java.util.stream.Collectors;

public class CoreAPIDemo {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(2, 16, 4, 12, 38, 15, 1);
		List<Integer> singleDigits = numbers.stream().filter(v -> v < 10).collect(Collectors.toUnmodifiableList());
		singleDigits.forEach(System.out::println);
	}

}
