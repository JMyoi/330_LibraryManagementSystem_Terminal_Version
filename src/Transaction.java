public class Transaction {
    private int userId;
    private int bookIsbn;
    private int transactionId;
    private int dateOfIssue;
    private int dueDate;
    private static int nextId;

    Transaction(){
        userId =0;
        bookIsbn =0;
        transactionId =0;
        dateOfIssue =0;
        dueDate = 0;
    }
    Transaction(int user, int book){
        userId = user;
        bookIsbn = book;

    }
    public void displayTransaction(){

    }

}
