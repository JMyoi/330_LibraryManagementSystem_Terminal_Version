import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        while(true) {
            System.out.println("welcome to the 330 Library Management System\n Would You like to\n" +
                    "1: Add a book\n" +
                    "2: Display all books\n");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            if (input == 1){
                library.addBook();
            }
            else if(input == 2){
                library.displayBooks();
            }
            else{
                System.out.println("Invalid Input");
            }
        }


    }
}