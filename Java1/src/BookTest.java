import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testGetTitle() {
        Book book = new Book("Test Title", "test Author", "1111111", 3030);
        assertEquals("Test Title", book.getTitle());
    }

    @Test
    public void testGetIsbn() {
        Book book = new Book("Test Title", "Test", "222222", 1900);
        assertEquals("222222", book.getIsbn());
    }
}
