
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Transaction> transactions;
    private User currentUser;
    Scanner input = new Scanner(System.in);

    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
        transactions = new ArrayList<>();
        currentUser = new User();
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public boolean Login(String userName, String pass){
        boolean isThere= false;
        for(User user: users){
            //System.out.println("checking username: "+ userName+ " and password :"+pass+"with "+user.getName()+"and authentication: "+user.authenticate(pass));
            if(user.getName().equals(userName) && user.authenticate(pass)){
                currentUser = user;
                isThere = true;
                break;
            }
        }
        return isThere;
    }
    public void Logout(){
        currentUser = new User();
        System.out.println("theoreticaly logged out");
        System.out.println(currentUser);
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
        System.out.println("Create a password: ");
        String password = input.nextLine();
        System.out.println("Is the new user a Librarian or Member? Enter L or M ");
        String UserType = input.nextLine();
        if (UserType.equals("L")) {
            Librarian temp = new Librarian( name, password);
            users.add(temp);
        } else if (UserType.equals("M")) {
            Member temp = new Member(name, password);
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
            return;
        } else {
            System.out.println("********************Books in the library*************************");
            for (int i = 0; i<books.size(); i++) {
                System.out.println(i+1 +" ");
                books.get(i).printInfo();
            }
            System.out.println("***************************************************************");
        }
        if(currentUser instanceof Member) {
            System.out.println("1: checkout a book\n2: return to menu");
            int key = input.nextInt();
            switch (key) {
                case 1:
                    System.out.println("Enter the book index you want to checkout: ");
                    int bookNum = input.nextInt();
                    if (bookNum <= 0 || bookNum > books.size()) {
                        System.out.println("Invalid Index");
                        break;
                    } else {
                        if(books.get(bookNum-1).noMoreCopies()){
                            System.out.println("Sorry, No more copies of this book.");
                        }else {
                            Transaction newTransaction = new Transaction(currentUser.getId(), books.get(bookNum - 1).getIsbn());
                            books.get(bookNum - 1).decrementCopy();
                            transactions.add(newTransaction);
                            System.out.println("Transaction Succesfull");
                        }
                    }
                    break;
                case 2:
                    break;
            }
        }
    }
    public void printAllTransactions(){
        for(int i = 0; i<transactions.size(); i++){
            transactions.get(i).displayTransaction();
        }
        if(transactions.size() == 0){
            System.out.println("No transactions");
        }
    }
    public void printCurrentUserTransactions(){
        if(transactions.isEmpty()){
            System.out.println("You have no Transactions");
            return;
        }
        for(int i = 0; i<transactions.size(); i++){
            if(transactions.get(i).getUserId() == currentUser.getId()){
                transactions.get(i).displayTransaction();
            }
        }
        System.out.println("\t1: remove a book\n\t2: return to menu");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("in progress");
        }

    }



}