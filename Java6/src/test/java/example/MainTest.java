package example;

import org.junit.Before;
import org.junit.Test;
import org.example.Main;
import static org.junit.Assert.*;
public class MainTest {
    private Main cinema;

    @Before
    public void setUp() {
        cinema = new Main(5, 10, 20);
    }

    @Test
    public void testBookSeats() {
        cinema.bookSeats(1, 1, new int[] { 1, 2, 3 });
        assertTrue(cinema.checkAvailability(1, 7));
    }

    @Test
    public void testCancelBooking() {
        cinema.bookSeats(3, 3, new int[] { 5, 6, 7 });
        cinema.cancelBooking(2, 2, new int[] { 5, 6 });
        cinema.printSeatingArrangement(2);
        assertTrue(cinema.checkAvailability(2, 3));
    }

    @Test
    public void testCheckAvailability() {
        for (int i = 0; i <= 10; i++) {
            cinema.bookSeats(3, i, new int[] { 8, 9, 10, });
        }
        assertFalse(cinema.checkAvailability(3, 18));
    }

    @Test
    public void testPrintHall() {
        cinema.printSeatingArrangement(4);
    }

    @Test
    public void testFindBestAvailable() {
        for (int i = 0; i <= 3; i++) {
            cinema.bookSeats(4, i, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        }
        int[] bestAvailable = cinema.findBestAvailable(4, 3);
        assertArrayEquals(new int[] { 1, 11 }, bestAvailable);
    }

    @Test
    public void testAutoBook() {
        for (int i = 0; i <= 10; i++) {
            cinema.bookSeats(5, i, new int[] { 8, 9, 10, });
        }
        cinema.autoBook(5, 11);
        cinema.printSeatingArrangement(5);
        assertFalse(cinema.checkAvailability(5, 11));
    }
}
