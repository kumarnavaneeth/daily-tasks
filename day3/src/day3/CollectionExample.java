package day3;

import java.util.List;
import java.util.*;
public class CollectionExample {
public static void main(String[] args) {
	List<String> fruits=new ArrayList<>();
	fruits.add("mango");
	fruits.add("apple");
	fruits.add("apple");
	fruits.add("guava");
	fruits.add(new String("guava"));
	System.out.println(fruits);
	System.out.println(fruits.size());
	for(String b:fruits){
		System.out.println(b);
	}
	//ref check
	System.out.println(fruits.get(1)==fruits.get(2));//string has same address because new object is not created
	System.out.println(fruits.get(3)==fruits.get(4));//in this case new is used so address will be diff
}
}
