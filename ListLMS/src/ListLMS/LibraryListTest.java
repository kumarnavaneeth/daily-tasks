package ListLMS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class LibraryListTest {
	LibraryList library;
	@BeforeEach
	void setup() {
		library=new LibraryList();
	}
	@Test
	void testReserveBookByTitleNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserveBook(null);//for excetion use assertthrows
		});
	}
	@Test
	void testReserveBookByTitleBlank() {
		assertThrows(IllegalArgumentException.class,()->{
			library.reserveBook("");
		});
	}
	@Test
	void testReserveBookTitleByWhiteSpace() {
		assertThrows(IllegalArgumentException.class,()->{
			library.reserveBook(" ");
		});
	}
	@Test
	void testSuccesfulReservation() {
		Book book=new Book(1,"Hellojava",30.3f);
		library.book.add(book);
		library.reserveBook("Hellojava");
		assertEquals(BookStatus.RESERVED,book.getStatus());
	}
}
