
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    Scanner input = new Scanner(System.in);

    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
        //add pre-existing users.
    }

    //can only be done by librarians
    public void displayUsers(){
        if(users.isEmpty()){
            System.out.println("No Users");
        }
        else{
            System.out.println("******************** Users *************************");
            for(User user: users){
                user.printInfo();
            }
            System.out.println("****************************************************");

        }
    }

    public void addUser() {
        System.out.println("Enter the Users Name");
        String name = input.nextLine();
        System.out.println("Is the new user a Librarian or Member? Enter L or M ");
        String UserType = input.nextLine();
        if (UserType.equals("L")) {
            System.out.println("Enter the new Librarians employeeId");
            String ID = input.nextLine();
            Librarian temp = new Librarian(ID, name);
            users.add(temp);
        } else if (UserType.equals("M")) {
            System.out.println("Enter the new members card number: ");
            String cardNum = input.nextLine();
            Member temp = new Member(cardNum, name);
            users.add(temp);
        } else {
            System.out.println("INVALID INPUT");
        }
    }

    public void addBook(){
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