import java.util.Scanner;
import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        UUID id = UUID.randomUUID();
        System.out.println("UUID" + id);
        System.out.println(id.getClass().getSimpleName());
        UUID id2 = UUID.randomUUID();
        System.out.println("UUID" + id2);
        System.out.println("comparing with compare to: "+ id.compareTo(id2));
        System.out.println("comparing with equals(): "+ id.equals(id2));

        System.out.println("making a copy and then comparing it again:");
        UUID copy = id;
        System.out.println("copy UUID" + copy);
        System.out.println("comparing with compare to: "+ id.compareTo(copy));
        System.out.println("comparing with equals(): "+ id.equals(copy));


        while(true) {
            Scanner in = new Scanner(System.in);
            boolean invalid = false;
            while (!invalid) {
                System.out.println("**************************************************\n" +
                        "welcome to 330 Library Management System\n" +
                        "1) Login\n" + "2) Create Account\n" +
                        "**************************************************");
                int input = in.nextInt();
                switch (input) {
                    case 1:
                        Scanner jin = new Scanner(System.in);
                        System.out.println("User Name: ");
                        String name = jin.nextLine();
                        System.out.println("Password: ");
                        String password = jin.nextLine();
                        if (library.Login(name, password)) {
                            System.out.println("Successfully Logged In");
                            invalid = true;
                        } else {
                            System.out.println("Incorrect credentials!");
                        }
                        break;
                    case 2:
                        library.addUser();
                        break;
                    default:
                        System.out.println("Incorrect Input");
                }
            }
            boolean logout = false;
            while (!logout) {
                //if the user is a librarian or a member display the appropriate menus
                if (library.getCurrentUser() instanceof Member) {
                    Member currMember = (Member) library.getCurrentUser();
                    System.out.println("********************************\n" + "Welcome ");
                    currMember.printInfo();
                    System.out.println("\t1: Display Books\n\t2: My Books \n\t3: logout");
                    int input = in.nextInt();
                    switch (input) {
                        case 1:
                            library.displayBooks();
                            break;
                        case 2:
                            library.printCurrentUserTransactions();
                            break;
                        case 3:
                            logout = true;
                            library.Logout();
                            break;
                    }

                } else if (library.getCurrentUser() instanceof Librarian) {
                    Librarian currLibrarian = (Librarian) library.getCurrentUser();
                    System.out.println("********************************\n" + "Welcome ");
                    currLibrarian.printInfo();
                    System.out.println("\t1: Display all Users\n\t2: Add a book\n\t3: Display books\n\t4: Display all Transactions\n\t5: logout");
                    int input = in.nextInt();
                    switch (input) {
                        case 1:
                            library.displayUsers();
                            break;
                        case 2:
                            library.addBook();
                            break;
                        case 3:
                            library.displayBooks();
                            break;
                        case 4:
                            library.printAllTransactions();
                            break;
                        case 5:
                            logout = true;
                            library.Logout();
                            break;
                    }
                }
            }

        }
    }
}