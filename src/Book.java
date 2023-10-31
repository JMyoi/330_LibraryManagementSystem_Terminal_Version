import java.util.Scanner;
public class Book  {
    private String isbn;
    private String bookName;
    private String authorName;
    //private int bookQtyCopy;

    public Book() {
        isbn = "";
        bookName ="";
        authorName ="";
    }
    public Book(String isbn, String bookName, String authorName){
        this.isbn = isbn;
        this.bookName = bookName;
        this.authorName = authorName;
    }
    public void printInfo(){
        System.out.println("BookName = "+bookName+"\nauthor = "+authorName+"\nisbn = "+isbn);
    }

}

//System.out.println("Enter Serial No of Book:");
//        this.sNo = input.nextInt();
//        input.nextLine();
//
//        System.out.println("Enter Book Name:");
//        this.bookName = input.nextLine();
//
//        System.out.println("Enter Author Name:");
//        this.authorName = input.nextLine();
//
//        System.out.println("Enter Quantity of Books:");
//        this.bookQty = input.nextInt();
//        bookQtyCopy = this.bookQty;