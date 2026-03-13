package ListLMS;
import java.util.*;
public class LibraryList {
List<Book> book=new ArrayList<>();
public void add(int bookid,String title,float price) {
		book.add(new Book(bookid,title,price));
	System.out.println("book added");
}
public void removeBook(String title) {
 for(int i=0;i<book.size();i++) {
	 if(book.get(i).title.equals(title)) {
		 book.remove(i);
		 System.out.println("book removed successfully");
		 return;
	 }
 }
 if(book.isEmpty()) {
	 System.out.println("book not found");
 }
}

public void displayBook() {
	// TODO Auto-generated method stub
	if(book.size()==0) {
		System.out.println("no books available");
	}
	for(Book b:book) {
		System.out.println("Book id"+b.Bookid);
		System.out.println("title"+b.title);
		System.out.println("price"+b.price);
		System.out.println("status"+b.status);
	}
}
public void reserveBook(String title) {
	for(Book b:book) {
		if(b.title.equals(title)) {
			if(b.status==BookStatus.AVAILABLE) {
				b.status=BookStatus.RESERVED;
				System.out.println("Book reserved");
			}
			else {
			System.out.println("book already reserved");
			}
			return;
		}
	}
}
}
