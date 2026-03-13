package day3;
import java.util.*;
public class HashMapExample {
public static void main(String[] args) {
	HashMap<Integer,String> map=new HashMap<>();
	map.put(1, "java");
	map.put(2, "pyton");
	map.put(3, "go");
	System.out.println(map);
	System.out.println(map.get(2));
}
}
