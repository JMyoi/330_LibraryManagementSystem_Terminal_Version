import java.util.Scanner;
public class Book  {

    private String isbn;
    private String bookName;
    private String authorName;
    private int numCopies;
    public Book() {
        numCopies = 0;
        isbn = "";
        bookName ="";
        authorName ="";
    }
    public Book(String isbn, String bookName, String authorName, int copies){
        numCopies = copies;
        this.isbn = isbn;
        this.bookName = bookName;
        this.authorName = authorName;
    }
    public String getName(){
        return bookName;
    }
    public boolean noMoreCopies(){
        return numCopies<=0;
    }
    public String getIsbn(){
        return isbn;
    }
    public void printInfo(){
        System.out.println("\tBookName = "+bookName+"\n\tauthor = "+authorName+"\n\tISBN = "+isbn+"\n\tNumber of Copies = "+numCopies);
    }

    public void decrementCopy(){
        numCopies--;
    }
    public void incrementCopy(){numCopies++;}
}
