package org.example;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable{
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public void lendItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && !item.isBorrowed()) {
            patron.borrow(item);
            item.borrowItem();
        }

    }
    public Item findItemByID(String uniqueID) {
        for (Item item : items) {
            if (item.getUniqueID().equals(uniqueID)) {
                return item;
            }
        }
        return null;
    }

    public Patron findPatronByID(String patronID) {
        for (Patron patron : patrons) {
            if (patron.getID().equals(patronID)) {
                return patron;
            }
        }
        return null;
    }
    public void returnItem(Patron patron, Item item) {
        if (patrons.contains(patron) && items.contains(item) && item.isBorrowed()) {
            patron.returnItem(item);
            item.returnItem();
        }
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }

    @Override
    public void listAvailable() {
        System.out.println("Available Items: ");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println("[ title - " + item.getTitle() + ", uniqueID - " + item.getUniqueID() + " ]");
            }
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("Borrowed Items:");
        for (Patron patron : patrons) {
            for (Item item : patron.getBorrowedItems()) {
                System.out.println(patron.getName() + " borrowed " + "[ title - " + item.getTitle() + ", uniqueID - " + item.getUniqueID() + " ]");
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
    public List<Patron> getPatrons() {
        return patrons;
    }
}
