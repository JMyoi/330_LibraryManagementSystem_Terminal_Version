import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("welcome to 330 Library Management System");

        while(true) {
            System.out.println("***********************************************\n" +
                    "1: Add a book\n" +"2: Add a user\n"+
                    "3: Display all books\n" +"4: Display all users\n"
                    +"***********************************************");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            if (input == 1){
                library.addBook();
            }
            else if(input == 2){
                library.addUser();
            }
            else if(input == 3){
                library.displayBooks();
            }
            else if (input == 4){
                library.displayUsers();
            }
            else{
                System.out.println("Invalid Input");
            }
        }


    }
}