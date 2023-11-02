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
            System.out.println(
                    "********************************\n" +
                    "Welcome "+ library.getCurrentUserName() +
                    "\n1: Add a book\n" +
                    "2: Display all books\n" +
                            "3: Display all users\n"
                    +"***********************************************");
            int input = in.nextInt();
            if (input == 1){
                library.addBook();
            }
            else if(input == 2){
                library.displayBooks();
            }
            else if (input == 3){
                library.displayUsers();
            }
            else{
                System.out.println("Invalid Input");
            }
        }


    }
}