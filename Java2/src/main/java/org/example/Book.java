package org.example;

public class Book extends Item {
    private String author;

    public Book(String title, String uniqueID, String author) {
        super(title, uniqueID);
        this.author = author;
    }

    @Override
    public void  borrowItem() {
        super.borrowItem(); // Implements the abstract method from Item.
    }

    @Override
    public void  returnItem() {
        super.returnItem(); // Implements the abstract method from Item.
    }
}
