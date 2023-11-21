import java.util.UUID;
public class Transaction {
    private UUID userId;
    private String bookIsbn;
    //private int transactionId;
    //private int dateOfIssue;
    //private int dueDate;
    //private static int nextId;
    Transaction(){
        userId = null;
        bookIsbn = null;
    }
    Transaction(UUID user, String book){
        userId = user;
        bookIsbn = book;

    }
    public UUID getUserId(){
        return userId;
    }
    public void displayTransaction(){
        System.out.println("BookISBN: " + bookIsbn + "UserId: " +userId);
    }

}
