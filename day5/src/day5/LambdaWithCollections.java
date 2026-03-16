package day5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaWithCollections {
public static void main(String[] args) {
	List<String> names=Arrays.asList("Java","python","go");
	consumer();
	comparator();
}
private static void comparator() {
	List<String> names=Arrays.asList("java","python","go");
	names.sort((str1,str2)->{
		return str2.length()-str1.length();});
	System.out.println(names);
}
private static void consumer() {
//Consumer<String> consumer=(String name)->System.out.println(name);
	//consumer<String> consumer=(name)->System.out.println(name);//consumer take only one parametrand reuturn nothing
	//Consumer<String> consumer=name->System.out.println(name);
	//for multiple lines we need to put curly braces,end with semicolon
	List<String> names=Arrays.asList("Java","python","go");
	Consumer<String> consumer=name->{
		System.out.println("name");
		System.out.println(name);
	};
	names.forEach(consumer);
}
}