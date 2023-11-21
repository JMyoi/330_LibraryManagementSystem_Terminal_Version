import java.util.Scanner;
public class Book  {

    private String isbn;
    private String bookName;
    private String authorName;

    private int numCopies;

    public Book() {
        numCopies = 1;
        isbn = "";
        bookName ="";
        authorName ="";
    }
    public boolean noMoreCopies(){
        return numCopies<=0;
    }
    public String getIsbn(){
        return isbn;
    }
    public Book(String isbn, String bookName, String authorName){
        numCopies = 1;
        this.isbn = isbn;
        this.bookName = bookName;
        this.authorName = authorName;
    }
    public void printInfo(){
        System.out.println("\tBookName = "+bookName+"\n\tauthor = "+authorName+"\n\tisbn = "+isbn);
    }

    public void decrementCopy(){
        numCopies--;
    }
}
