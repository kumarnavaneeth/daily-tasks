package ListLMSusingWritefile;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
public class Mainfunction {
	private static final Logger logger=Logger.getLogger(Mainfunction.class.getName());
public static void main(String[] args) throws IOException {
	LibraryList list=new LibraryList();
Scanner sc=new Scanner(System.in);
boolean menu=false;
while(!menu){
//	System.out.println("enter your choice");
	logger.info("enter your choice");
	int choice=sc.nextInt();
switch(choice) {
case 1:
//	System.out.println("enter the book id");
	logger.info("enter book id");
	int bookid=sc.nextInt();
	sc.nextLine();
		
//	System.out.println("enter the book name");
	logger.info("enter book name");
	String title=sc.nextLine();

//	System.out.println("enter the book price");
	logger.info("enter book price");
	float price=sc.nextFloat();
	list.add(bookid,title,price);
	break;
case 2:
		//System.out.println("enter book title to remove book");
	logger.info("enter book title to remove book");
		title=sc.next();
		list.removeBook(title);
		break;
case 3:	list.displayBook();
		break;
case 4://System.out.println("enter title to reserve");
	logger.info("enter book title to reserve");
	title=sc.next();
	list.reserveBook(title);
		break;
default://System.out.println("invalid choice");
		logger.info("invalid choice");
		
}

}

}
}

