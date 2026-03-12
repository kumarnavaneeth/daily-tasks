package ListLMS;
import java.util.*;
public class LibraryList {
List<Book> book=new ArrayList<>();
public void add(int bookid,String title,float price) {
		book.add(new Book(bookid,title,price));
	System.out.println("book added");
}
public void removeBook(String title) {
	if(title.isEmpty()) {
	System.out.println("no ooks found");
	}
}

}
