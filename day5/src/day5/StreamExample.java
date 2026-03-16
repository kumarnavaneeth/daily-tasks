package day5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
public static void main(String[] args) {
	//stream1();
	//streamwithchain(); //easier
	comparatorWithAnonymousInnerClass();
}
private static void stream1() {
	List<Integer> numbers=Arrays.asList(1,2,3,4,5);//tank
	Stream<Integer> stream=numbers.stream();//pipeline
	Stream<Integer> squaredStream=stream.map(number->number*number);//apply logic on each and every element
	Stream<Integer> filteredStream=squaredStream.filter((number)->{
		System.out.println(number);
	return number%2 !=0;
});
System.out.println(filteredStream.count());	
}
private static void streamwithchain() {
	List<Integer> numbers=Arrays.asList(1,2,3,4,5);
	Stream<Integer> finalStream=numbers.stream().parallel().map(number->{
		if(number%2==1) { //or instead of if condition return (number%2==1)? number*number:number;
			return number*number;
		}else {
			return number;
		}
	}).filter((number)->{
		System.out.println(number);
		return number %2 !=0;
	});
//	System.out.println(finalStream.count());
	List finalList=finalStream.collect(Collectors.toList());
	finalList.forEach(x->System.out.println(x));
	finalList.forEach(System.out::println);
//	System.out.println(finalList);
}
private static void comparatorWithAnonymousInnerClass(){
	List<String> names=Arrays.asList("java","python","go");
	names.sort(new Comparator<String>() {
		public int compare(String o1,String o2) {
			return o1.length()-o2.length();
		}
	});
	System.out.println(names);
}
}
