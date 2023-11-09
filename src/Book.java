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
