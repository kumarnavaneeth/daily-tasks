package day5;

import java.util.function.Predicate;

public class PredicateExample {
public static void main(String[] args) {
//	Predicate<Integer> isEven=n->n%2==0;
	Predicate<Integer> isEven=(Integer n)->n%2==0;
//	Predicate<Integer> isEven=n->{
//		return n%2 ==0;//if we have one then return will be automatically taken,if we have more,we need to specif
//	};
	System.out.println(isEven.test(10));//test is inside predicate 
}
}
