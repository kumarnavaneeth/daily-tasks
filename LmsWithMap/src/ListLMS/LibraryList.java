package ListLMS;
import java.util.*;
public class LibraryList {
Map<Integer,Book> book=new HashMap<Integer,Book>();
public void add(int bookid,String title,float price) {
		book.add(new Book(bookid,title,price));
	System.out.println("book added");
}
public void removeBook(String title) {
	if(book.isEmpty()) {
		System.out.println("No book found");
	}
	for(Book b:book) {
		if(b.title==title) {
			book.remove(title);
			System.out.println("book removed");
			return;
		}
	}
}

public void displayBook() {
	// TODO Auto-generated method stub
	for(Book display:book) {
		System.out.println(display);
	}
}
}
