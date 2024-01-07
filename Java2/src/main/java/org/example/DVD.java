package org.example;

public class DVD extends Item {
    private int duration;

    DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        super.borrowItem(); // Implements the abstract method from Item.
    }

    @Override
    public void returnItem() {
        super.returnItem(); // Implements the abstract method from Item.
    }
}
