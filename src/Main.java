import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

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
                }
            }
            boolean logout = false;
            while (!logout) {
                //if the user is a librarian or a member display the appropriate menus
                if (library.getCurrentUser() instanceof Member) {
                    Member currMember = (Member) library.getCurrentUser();
                    System.out.println("********************************\n" + "Welcome ");
                    currMember.printInfo();
                    System.out.println("1: Display Books\n2: My Books\n3: logout");
                    int input = in.nextInt();
                    switch (input) {
                        case 1:
                            library.displayBooks();
                            break;
                        case 2:
                            System.out.println("method still in progress");
                            break;
                        case 3:
                            logout = true;
                            break;
                    }

                } else if (library.getCurrentUser() instanceof Librarian) {
                    Librarian currLibrarian = (Librarian) library.getCurrentUser();
                    System.out.println("********************************\n" + "Welcome ");
                    currLibrarian.printInfo();
                    System.out.println("1: Display all Users\n2: Add a book\n3: Display books\n4: logout");
                    int input = in.nextInt();
                    switch (input) {
                        case 1:
                            library.displayUsers();
                            break;
                        case 2:
                            library.addBook();
                            break;
                        case 4:
                            logout = true;
                            break;
                    }
                }
            }

        }
    }
}