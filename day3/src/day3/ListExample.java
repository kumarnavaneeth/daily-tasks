package day3;

import java.util.*;
public class ListExample {
public static void main(String[] args) {
	List<String> cities=new LinkedList<>();
	cities.add("mangalore");
	cities.add("bengaluru");
	cities.add("kasaragod");
	if(cities instanceof LinkedList<String>) {
	LinkedList<String> linkedlist=((LinkedList)cities);//downcasting //d this
	linkedlist.addFirst("a");
	}
	System.out.print(cities);
	System.out.print(cities.contains("Kasaragod"));//contains is case sensitive
}
}
