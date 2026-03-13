package ListLMS;
import java.util.*;
public class Mainfunction {
public static void main(String[] args) {
	LibraryList list=new LibraryList();
Scanner sc=new Scanner(System.in);
boolean menu=false;
while(!menu){
	System.out.println("enter your coice");
	int choice=sc.nextInt();
switch(choice) {
case 1:
	System.out.println("enter the book id");
	int bookid=sc.nextInt();
	sc.nextLine();
		
	System.out.println("enter the book name");
	String title=sc.nextLine();

	System.out.println("enter the book price");
	float price=sc.nextFloat();
	list.add(bookid,title,price);
	break;
case 2:
		System.out.println("enter book title to remove book");
		title=sc.nextLine();
		list.removeBook(title);
		break;
case 3:	list.displayBook();
		break;
default:System.out.println("invalid choice");
}
}
}
}

