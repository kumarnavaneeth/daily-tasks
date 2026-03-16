package ListLMSusingWritefile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
public class LibraryList {
private static final Logger logger=Logger.getLogger(LibraryList.class.getName());
List<Book> book=new ArrayList<>();
public void add(int bookid,String title,float price) {//if not using try catch use throws exception here,in main also
	try {
		Book newbook=new Book(bookid,title,price);
		book.add(newbook);
		FileWriter writer=new FileWriter("bookfile.txt",true);
		writer.write(bookid+","+title+","+price+"\n");
		writer.flush();
		writer.close();
//	System.out.println("book added");
		logger.info("Book added succesfully");
	}
	catch(IOException e) {
		logger.info("error in adding book");
	}
}
public void removeBook(String title) {
 for(int i=0;i<book.size();i++) {
	 if(book.get(i).title.equals(title)) {
		 book.remove(i);
//		 System.out.println("book removed successfully");
		 logger.info("book removed successfully");
		 return;
	 }
 }
 if(book.size()==0) {
	 //System.out.println("book not found");
	 logger.info("book not fund");
 }
}

public void displayBook() {
	try {
	readFile();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	if(book.size()==0) {
		//System.out.println("no books available");
		logger.info("no book available");
	}
	for(Book b:book) {
		System.out.println("Book id"+b.Bookid);
		System.out.println("title"+b.title);
		System.out.println("price"+b.price);
		System.out.println("status"+b.status);
	}
}
	//using readfile  
	private void readFile() throws IOException {
		BufferedReader reader=new BufferedReader(new FileReader("bookfile.txt"));
		String line;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
		reader.close();
	}
	
public void reserveBook(String title) throws BookNotAvailableException {
	for(Book b:book) {
		if(b.title.equals(title)) {
			if(b.status==BookStatus.AVAILABLE) {
				b.status=BookStatus.RESERVED;
				//System.out.println("Book reserved");
				logger.info("Book reserved");
			}
//			else {
//			//System.out.println("book already reserved");
//				logger.info("book already reserved");
//			}
//			return;
		}
	}
//custom exception
	throw new BookNotAvailableException("Book is not available");
}
}
