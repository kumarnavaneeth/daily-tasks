package ListLMS;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryListTest {
	LibraryList library;

	@BeforeEach
	void setup() {
		library = new LibraryList();
	}

	@Test
	void testReserveBookByTitleNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserveBook(null);// for excetion use assertthrows
		});
	}

	@Test
	void testReserveBookByTitleBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserveBook("");
		});
	}

	@Test
	void testReserveBookTitleByWhiteSpace() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.reserveBook(" ");
		});
	}

	@Test
	void testSuccessfulReservation() {
		Book book = new Book(1, "Hello java", 30.3f);
		library.book.add(book);
		library.reserveBook("Hello java");
		assertEquals(BookStatus.RESERVED, book.getStatus());
	}

	@Test
	void testBookNotAvailable() {
		assertThrows(BookNotAvailableException.class, () -> {
			library.reserveBook("good");
		});
	}

	@Test
	void testAddBookByTitleNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.add(1, null, 20.4f);
		});
	}

	@Test
	void testAddBookByTitleBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.add(2, "", 20.45f);
		});
	}

	@Test
	void testAddBookByTitleWhiteSpace() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.add(3, " ", 33.4f);
		});
	}

	@Test
	void testAddBookByIdNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.add(-1, "java basics", 12.3f);
		});
	}

	@Test
	void testAddBookByPriceNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.add(3, "the god", -2);
		});
	}
@Test
void addBookSuccess() {
	Book book=new Book(12,"openai",23.4f);
	library.book.add(book);
}
	@Test
	void testRemoveBookByTitleNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.removeBook(null);
		});
	}

	@Test
	void testRemoveBookByTitleBlank() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.removeBook("");
		});
	}

	@Test
	void testRemoveBookByTitleWithWhiteSpaces() {
		assertThrows(IllegalArgumentException.class, () -> {
			library.removeBook(" ");
		});
	}

	@Test
	void testRemoveBookWithWrongTitle() {
		assertThrows(BookNotAvailableException.class, () -> {
			library.removeBook("animals");
		});
	}
	@Test
	void testRemoveBookByTitleSuccess() {
		Book book=new Book(12,"run chase",20.4f);
		library.book.add(book);
		library.removeBook("run chase");
	}

	@Test
	void testDisplayBook() {
		final ByteArrayOutputStream outStreamcaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStreamcaptor));
		Book book = new Book(1, "rocker", 90.5f);
		library.book.add(book);
		library.displayBook();
		assertTrue(outStreamcaptor.toString().trim().contains(book.toString()));
		System.setOut(System.out);
	}
	@Test
	void testDisplayBookforEmpty() {
		ByteArrayOutputStream outStreamCapacitor=new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStreamCapacitor));
		library.displayBook();
		String output=outStreamCapacitor.toString().trim();
		assertTrue(output.isEmpty());
	}
}
