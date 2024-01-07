package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        boolean auth = false;
        String patronID = "";
        while (true) {
            if(auth) {
                int choice;
                do {
                    authPatronMenuBar();
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            addItem(scanner, library);
                            break;
                        case 2:
                            removeItem(library, scanner);
                            break;
                        case 4:
                            lendItem(library, scanner, patronID);
                            break;
                        case 5:
                            returnItem(library, scanner, patronID);
                            break;
                        case 6:
                            library.listAvailable();
                            break;
                        case 7:
                            library.listBorrowed();
                            break;
                        case 0:
                            System.out.println("Goodbye!");
                            auth = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                } while (choice != 0);
            } else {
                unauthorizedPatronMenuBar();
                int choiceAuth = scanner.nextInt();
                scanner.nextLine();
                switch (choiceAuth) {
                    case 1:
                        String[] arrayPatron = loginPatronMenuBar(scanner);
                        Patron patron = new Patron(arrayPatron[0], arrayPatron[1]);
                        patronID = arrayPatron[1];
                        library.registerPatron(patron);
                        auth = true;
                }
            }
        }
    }

    private static void authPatronMenuBar() {
        System.out.println("\nLibrary Management System Menu:");
        System.out.println("Choose an action:");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Register Patron");
        System.out.println("4. Lend Item");
        System.out.println("5. Return Item");
        System.out.println("6. List Available Items");
        System.out.println("7. List Borrowed Items");
        System.out.println("0. Exit");
    }
    private static void unauthorizedPatronMenuBar() {
        System.out.println("Choose an action:");
        System.out.println("1. Authorized");
        System.out.println("0. Exit");
    }

    private static String[] loginPatronMenuBar(Scanner scanner) {
        System.out.println("Pleas entre your name: ");
        String name = scanner.nextLine();
        System.out.println("Pleas entre your or write 'r' for random: ");
        String ids = scanner.nextLine();
        if (Objects.equals(ids, "r") || Objects.equals(ids, "")) {
            ids = generationIdsPatron();
        }
        return new String[]{name, ids};
    }

    private static String generationIdsPatron() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }

    private static void addItem(Scanner scanner, Library library) {
        System.out.print("Enter the type of item (Book/DVD): ");
        String itemType = scanner.nextLine();

        System.out.print("Enter the title: ");
        String title = scanner.nextLine();
        String uniqueId = generationIdsPatron();
        if ("Book".equalsIgnoreCase(itemType)) {
            System.out.print("Enter the author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, uniqueId, author);
            library.add(book);
            System.out.println("Book added successfully.");
        } else if ("DVD".equalsIgnoreCase(itemType)) {
            System.out.print("Enter the duration (minutes): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            DVD dvd = new DVD(title, uniqueId, duration);
            library.add(dvd);
            System.out.println("DVD added successfully.");
        } else {
            System.out.println("Invalid item type. Please enter either 'Book' or 'DVD'.");
        }
    }

    private static void removeItem(Library library, Scanner scanner) {

        System.out.print("Enter the unique ID of the item to be removed: ");
        String uniqueID = scanner.nextLine();
        Item itemToRemove = library.findItemByID(uniqueID);
        if (itemToRemove != null) {
            library.remove(itemToRemove);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item with ID " + uniqueID + " not found.");
        }
    }

    private static void lendItem(Library library, Scanner scanner, String patronID) {
        Patron patron = library.findPatronByID(patronID);
        if (patron != null) {
            System.out.print("Enter the unique ID of the item to be lent: ");
            String itemID = scanner.nextLine();
            Item itemToLend = library.findItemByID(itemID);

            if (itemToLend != null && !itemToLend.isBorrowed()) {
                library.lendItem(patron, itemToLend);
                System.out.println("Item lent successfully.");
            } else {
                System.out.println("Item not available for lending.");
            }
        } else {
            System.out.println("Patron with ID " + patronID + " not found.");
        }
    }

    private static void returnItem(Library library, Scanner scanner, String patronID) {
        Patron patron = library.findPatronByID(patronID);

        if (patron != null) {
            System.out.print("Enter the unique ID of the item to be returned: ");
            String itemID = scanner.nextLine();
            Item itemToReturn = library.findItemByID(itemID);

            if (itemToReturn != null && patron.hasBorrowedItem(itemToReturn)) {
                library.returnItem(patron, itemToReturn);
                System.out.println("Item returned successfully.");
            } else {
                System.out.println("Patron hasn't borrowed the specified item.");
            }
        } else {
            System.out.println("Patron with ID " + patronID + " not found.");
        }
    }
}