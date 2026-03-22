package ListLMS;

import java.util.*;
import static ListLMS.ValidateUtils.*;
import java.util.logging.Logger;

public class LibraryList {
	private static final Logger logger = Logger.getLogger(LibraryList.class.getName());
	List<Book> book = new ArrayList<>();

	public void add(int bookid, String title, float price) {
		if (!validateStringValues(title) || !validatePriceValue(price) || !validateIdValue(bookid)) {
			throw new IllegalArgumentException("invalid input");
		}
		book.add(new Book(bookid,title,price));
		logger.info("Book added succesfully");
	}

	public void removeBook(String title) {
		if (!validateStringValues(title)) {
			throw new IllegalArgumentException("invalid input");
		}
		for (int i = 0; i < book.size(); i++) {
			if (book.get(i).title.equals(title)) {
				book.remove(i);
				logger.info("book removed successfully");// instaed of print we use loggers
				return;
			}
		}
		throw new BookNotAvailableException("entered book is not found in the library");
	}

	public void displayBook() {
		// TODO Auto-generated method stub
		if (book.size() == 0) {
			// System.out.println("no books available");
			logger.info("no book available");
		}
		for (Book b : book) {
			System.out.println(b);
		}
	}

	public void reserveBook(String title) throws BookNotAvailableException {
		if (!validateStringValues(title)) {
			throw new IllegalArgumentException("invalid input");
		}
		for (Book b : book) {
			if (b.title.equals(title)) {
				if (b.status == BookStatus.AVAILABLE) {
					b.status = BookStatus.RESERVED;
					// System.out.println("Book reserved");
					logger.info("Book reserved");
					return;
				}
			}
		}
		throw new BookNotAvailableException("Book is not available");
	}
}
