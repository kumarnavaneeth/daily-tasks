package ListLMS;
import java.util.*;
public class Mainfunction {
public static void main(String[] args) {
	LibraryList list=new LibraryList();
Scanner sc=new Scanner(System.in);
//int choice =sc.nextInt();
//System.out.println("enter the book id");
//int bookid=sc.nextInt();
//sc.nextLine();
//
//System.out.println("enter the book name");
//String title=sc.nextLine();
//
//System.out.println("enter the book price");
//float price=sc.nextFloat();
//list.add(bookid,title,price);
System.out.println("enter book title to remove book");
String title=sc.nextLine();
list.removeBook(title);
//System.out.println("enter book title to remove book");
//String title=sc.nextLine();
}
}
