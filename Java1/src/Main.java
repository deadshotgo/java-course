import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title, author, isbn;
    private int year;
    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAllBooks() {
        return "[ Title: " + title + ", Author: " + author + ", Years: " + year +  ", ISBN: " + isbn + "],\n";
    }
}


class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book.getAllBooks());
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean removeBookByIsbn(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        while (true) {
            menuBar();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter the author of the book:");
                    String author = scanner.nextLine();
                    System.out.println("Enter the ISBN of the book:");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter the publication year of the book:");
                    int year = scanner.nextInt();
                    addBook(title, author, isbn, year, library);
                    break;
                case 2:
                    System.out.println("All books in the library:");
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.println("Enter the book title to search for:");
                    String searchTitle = scanner.nextLine();
                    searchBook(searchTitle, library);
                    break;
                case 4:
                    System.out.println("Enter the ISBN of the book to delete:");
                    String isbnToRemove = scanner.nextLine();
                    removeBook(isbnToRemove, library);
                    break;
                case 0:
                    System.out.println("Thank you for using the library. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private static void menuBar() {
        System.out.println("Choose an action:");
        System.out.println("1. Add a book");
        System.out.println("2. Show all books");
        System.out.println("3. Search for a book by title");
        System.out.println("4. Delete a book by ISBN");
        System.out.println("0. Exit");
    }
   private static void addBook(String title, String author, String isbn, int year, Library library) {
        if(title.length() < 2 || author.length() < 2 || isbn.length() < 2) {
            System.out.println("Error create book");
            return;
        };
        Book newBook = new Book(title, author, isbn, year);
        library.addBook(newBook);
        System.out.println("Book is success create");
    }

   private static void searchBook(String title, Library library) {
       Book foundBook = library.searchBookByTitle(title);
       if (foundBook != null) {
           System.out.println("Found book by title: " + foundBook);
       } else {
           System.out.println("Book not found with title: " + title);
       }
   }

    private static void removeBook(String isbn, Library library) {
        if (library.removeBookByIsbn(isbn)) {
            System.out.println("Book with ISBN " + isbn + " removed successfully.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found in the library.");
        }
    }
}