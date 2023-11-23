
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Transaction> transactions;
    private User currentUser;
     //private Scanner input = new Scanner(System.in);


    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
        transactions = new ArrayList<>();
        currentUser = new User();
        try {
            loadDefaultUser();
            loadDefaultBooks();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
            System.out.println(e.getMessage());
        }
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public boolean Login(String userName, String pass){
        boolean isThere= false;
        for(User user: users){
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
        Scanner input = new Scanner(System.in);//____________________________________________________
        System.out.println("Enter the Users Name");
        String name = input.nextLine();
        //make sure the userName is unique
        for (User user : users) {
            if (user.getName().equals(name)) {
                System.out.println("User name already taken please use another name.");
                return;
            }
        }
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
        Scanner input = new Scanner(System.in);//____________________________________________________
        String bookName;
        String authorName;
        String isbn;
        int copies;
        System.out.println("Enter the name of the book: ");
        bookName = input.nextLine();
        System.out.println("Enter the name of the author: ");
        authorName = input.nextLine();
        System.out.println("Enter the ISBN: ");
        isbn = input.nextLine();
        System.out.println("Enter the number of copies: ");
        copies = input.nextInt();
        Book newBook = new Book(isbn, bookName, authorName,copies);
        books.add(newBook);
    }

    public void displayBooks() {
        Scanner input = new Scanner(System.in);//____________________________________________________
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
                        }
                        //if the user already has this book then they cannot get it again.
                        else{
                            ArrayList<Transaction> myTransactions = getUserTransactions();
                            boolean alreadyHave = false;
                            for (Transaction myTransaction : myTransactions) {
                                if (myTransaction.getBookIsbn().equals(books.get(bookNum - 1).getIsbn())) {
                                    alreadyHave = true;
                                    break;
                                }
                            }
                            if(alreadyHave){
                                System.out.println("You already have this book");
                            }else {
                                Transaction newTransaction = new Transaction(currentUser.getId(), currentUser.getName(), books.get(bookNum - 1).getIsbn(), books.get(bookNum - 1).getName());
                                books.get(bookNum - 1).decrementCopy();
                                transactions.add(newTransaction);
                                System.out.println("Transaction successful");
                            }
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
            System.out.println(i+1);
            System.out.println(transactions.get(i).toString());
        }
        if(transactions.isEmpty()){
            System.out.println("No transactions");
        }
    }
    public void printCurrentUserTransactions(){
        Scanner input = new Scanner(System.in);//____________________________________________________
        if(transactions.isEmpty()){
            System.out.println("No Transactions");
            return;
        }
        ArrayList<Transaction> myTransactions = getUserTransactions();
        System.out.println("*******************************************************");
        for(int i = 0; i<myTransactions.size(); i++){
            System.out.println(i+1);
            System.out.println(transactions.get(i).getBookInfo());
        }
        if(myTransactions.isEmpty()){
            System.out.println("You have no transactions");
            return;
        }
        System.out.println("*******************************************************");

        System.out.println("\t1: remove a book\n\t2: return to menu");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("which numbered index do you want to remove: ");
            int key = input.nextInt();
            Transaction removeThisTransaction = myTransactions.get(key-1);
            transactions.remove(removeThisTransaction);
            System.out.println("Successfully removed "+removeThisTransaction.getBookName());
            //put the copy back into the library by incrementing the count of the book
            for(int i = 0; i<books.size(); i++){
                if(books.get(i).getIsbn().equals(removeThisTransaction.getBookIsbn())){
                    books.get(i).incrementCopy();
                }
            }
        }
    }
    //returns an array of the currently logged-in users transactions.
    private ArrayList<Transaction> getUserTransactions(){
        ArrayList<Transaction> myTransactions = new ArrayList<>();
        for(int i = 0; i<transactions.size(); i++){
            if(transactions.get(i).getUserId() == currentUser.getId()){
                myTransactions.add(transactions.get(i));
            }
        }
        return myTransactions;
    }

    private void loadDefaultUser() throws FileNotFoundException {
        File inFile = new File("defaultUsers.txt");
        Scanner in = new Scanner(inFile);
        while(in.hasNext()){
            String userName = in.next();
            String Password = in.next();
            String type = in.next();
            if (type.equals("L")) {
                Librarian temp = new Librarian( userName, Password);
                users.add(temp);
            } else if (type.equals("M")) {
                Member temp = new Member(userName, Password);
                users.add(temp);
            }
        }

        in.close();
    }
    private void loadDefaultBooks() throws FileNotFoundException{
        File inFile = new File("defaultBooks.txt");
        Scanner in = new Scanner(inFile);
        while(in.hasNext()){
            String BookName = in.nextLine();
            String author = in.nextLine();
            String ISBN = in.nextLine();
            String amount = in.nextLine();

            System.out.println("name: "+BookName+"author: "+author+"ISBN: "+ISBN+"amount: "+amount);
        }
    }

}