package basics;
import java.util.*;
public class ListDemo {
	private static void StringSurprise() {
		String s1=new String("book1");//goes to string bool
		String s2=new String("book2");//string literal,goes to string constant pool
		String s3=new String("book3"); //string pool
		//if we compare address wont be sameor object,because every time we use new keyword,another new object is created.
		
	}
public static void main(String[] args) {
	List<String> list=new ArrayList<>();
	list.add("book1");
	list.add("book2");
	list.add("book3");
	list.add(5,"book4");
	list.remove(0);
	System.out.println(list.size());
	System.out.println("after remove="+list.size());
	list.forEach((book)->System.out.println(book));
}
}
