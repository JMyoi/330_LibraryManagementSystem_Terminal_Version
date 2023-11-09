import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library library = new Library();

        boolean invalid = true;
        while(invalid) {
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
                        invalid = false;
                    } else {
                        System.out.println("Incorrect credentials!");
                    }
                    break;
                case 2:
                    library.addUser();
                    break;
            }
        }

        while(true) {
            System.out.println("Current user type: " + library.getCurrentUser().getClass().getSimpleName());
            boolean isMember = library.getCurrentUser() instanceof Member;
            boolean isLibrarian = library.getCurrentUser() instanceof Librarian;
            System.out.println("is the current user an instance of Member?"+ isMember);
            System.out.println("is the current user an instance of Librarian?"+ isLibrarian);


            //if the user is a librarian or a member display the appropriate menus
            if(library.getCurrentUser() instanceof Member){
                Member currMember = (Member) library.getCurrentUser();
                System.out.println("********************************\n" + "Welcome ");
                currMember.printInfo();
                System.out.println("1: Display Books\n 2: My Books \n");
                int input = in.nextInt();
                switch(input){
                    case 1:
                        library.displayBooks();
                        break;
                    case 2:
                        System.out.println("method still in progress");
                        break;
                }

            }
            else if (library.getCurrentUser() instanceof Librarian){
                Librarian currLibrarian = (Librarian) library.getCurrentUser();
                System.out.println("********************************\n" + "Welcome ");
                currLibrarian.printInfo();
                System.out.println("1: Display all Users\n2: Add a book \n");
                int input = in.nextInt();
                switch(input){
                    case 1:
                        library.displayUsers();
                        break;
                    case 2:
                        library.addBook();
                        break;
                }
            }
        }


    }
}