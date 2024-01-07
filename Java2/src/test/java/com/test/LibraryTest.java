package com.test;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testAddItem() {
        Library library = new Library();
        Item book = new Book("Test first Book", "testest", "Test auth");
        library.add(book);

        assertTrue(library.getItems().contains(book));
    }

    @Test
    void testRemoveItem() {
        Library library = new Library();
        Item book = new Book("Test first Book", "testest", "Test auth");
        library.add(book);

        library.remove(book);

        assertFalse(library.getItems().contains(book));
    }

    @Test
    void testRegisterPatron() {
        Library library = new Library();
        Patron patron = new Patron("Test first Patron", "testtesttest");
        library.registerPatron(patron);

        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    void testLendItem() {
        Library library = new Library();
        Patron patron = new Patron("Test first Patron", "testtesttest");
        library.registerPatron(patron);
        Item book = new Book("Test Book one", "testtesttest", "test auth");
        library.add(book);

        library.lendItem(patron, book);

        assertTrue(patron.getBorrowedItems().contains(book));
        assertTrue(book.isBorrowed());
    }

    @Test
    void testReturnItem() {
        Library library = new Library();
        Patron patron = new Patron("Test first Patron", "testetsetset");
        library.registerPatron(patron);
        Item book = new Book("Test  first Book", "testsdds", "Test author");
        library.add(book);
        library.lendItem(patron, book);

        library.returnItem(patron, book);

        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed());
    }
}
