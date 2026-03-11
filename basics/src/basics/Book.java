package basics;
import java.util.*;
public class Book {
String title;
int price;
boolean available;
Book(String title,int price){
	this.title=title;
	this.price=price;
	this.available=false;
	if(price<0) { 
		System.out.println("low price");
	}
}
}
class Library{

    List<Book> books = new ArrayList<>();

    void addBook(String title,int price) {
        books.add(new Book(title,price));
    }

    void borrowBook(String title) {
        for(Book b : books) {
            if(b.title.equals(title) && b.available) {
                b.available = false;
                System.out.println("Borrowed: " + title);
                return;
            }
        }
        System.out.println("Book not available");
    }
void borrowBookByTitle(String title) {
	for(Book b:books) {
		if(b.title.equals(title)) {
			System.out.println("found" +title);
		}
	}
}
List<Book> find(String title){
	
}
    
    void displayBooks() {
        for(Book b : books)
            if(b.available)
                System.out.println(b.title);
    }

}
