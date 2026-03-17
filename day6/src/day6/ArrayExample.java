package day6;

public class ArrayExample {
public static void main(String[] args) {
	int[] numbers= {10,20,30,40,50};
	System.out.println(numbers[0]);
	arrayWithObjects();
}
private static void arrayWithObjects() {
	Book[] books=new Book[5];
	books[0]=new Book(1,"hello","steve", false);
	books[1]=new Book(2,"god","john",false);
	books[2]=new Book(3,"world","raj",false);
	System.out.println(id,title,author);
}
}
