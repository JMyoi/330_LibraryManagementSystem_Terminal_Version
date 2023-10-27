import java.util.ArrayList;
import java.util.Scanner;

public interface Library {
    // Class data members
    ArrayList<Book> books = new ArrayList<>();

    // Method to display all books in the library
    public default void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Serial No: " + book.sNo);
                System.out.println("Book Name: " + book.bookName);
                System.out.println("Author Name: " + book.authorName);
                System.out.println("Quantity of Books: " + book.bookQty);
                System.out.println();
            }
        }
    }
}