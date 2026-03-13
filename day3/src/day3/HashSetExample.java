package day3;

import java.util.HashSet;

public class HashSetExample {
public static void main(String[] args) {
	HashSet<Integer> numbers=new HashSet<>();//no rder,only linkedhashset maintans order
	numbers.add(10);
	numbers.add(20);
	numbers.add(10);
	System.out.println(numbers);
}
}
