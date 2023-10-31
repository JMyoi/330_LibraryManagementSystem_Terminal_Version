
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    Library(){
        books = new ArrayList<Book>();
        users = new ArrayList<User>();
        //add pre-existing users.

    }

    public void addBook(){
        Scanner input = new Scanner(System.in);
        String bookName;
        String authorName;
        String isbn;
        System.out.println("Enter the name of the book: ");
        bookName = input.nextLine();
        System.out.println("Enter the name of the author: ");
        authorName = input.nextLine();
        System.out.println("Enter the ISBN: ");
        isbn = input.nextLine();
        Book newBook = new Book(isbn, bookName, authorName);
        books.add(newBook);
    }
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("********************Books in the library*************************");
            for (Book book : books) {
                book.printInfo();
            }
            System.out.println("***************************************************************");
        }
    }

}