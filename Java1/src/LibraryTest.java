import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {
    private Library library;

    @Before
    public void setup() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test Title", "Test Author", "11111111", 3030);
        library.addBook(book);
        assertTrue(library.searchBookByTitle("Test Title") != null);
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book = new Book("Test Title", "Test Author", "11111111", 3030);
        library.addBook(book);
        assertTrue(library.removeBookByIsbn("11111111"));
        assertFalse(library.removeBookByIsbn("12231232132"));
    }
}
