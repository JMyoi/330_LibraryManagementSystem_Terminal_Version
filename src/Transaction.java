import java.util.UUID;
public class Transaction {
    private UUID userId;
    String userName;
    String bookName;
    private String bookIsbn;
    //private int transactionId;
    //private int dateOfIssue;
    //private int dueDate;
    //private static int nextId;
    Transaction(){
        userId = null;
        bookIsbn = null;
        userName = "";
        bookName = "";
    }
    Transaction(UUID user,String userName, String book, String bookName){
        userId = user;
        this.userName = userName;
        bookIsbn = book;
        this.bookName = bookName;

    }
    public UUID getUserId(){
        return userId;
    }
    public void displayTransaction(){
        System.out.println("BookISBN: " + bookIsbn + "UserId: " +userId);
    }
    public String toString() {
        return  "\tUser Name: " + userName+ "\n\tUserID: "+ userId+"\n\tBookName:"+bookName+"\n\tBook ISBN: "+ bookIsbn;
    }
    public String getBookInfo(){
        return "Book Name: "+bookName+ "\nBook ISBN: "+bookIsbn;
    }
    public String getBookName(){
        return bookName;
    }
    public String getBookIsbn(){
        return bookIsbn;
    }


}
