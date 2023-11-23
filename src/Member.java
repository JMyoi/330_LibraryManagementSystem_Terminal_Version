import java.util.UUID;

public class Member extends User {
    private UUID libraryCardNumber;


    public Member() {
        libraryCardNumber = UUID.randomUUID();
    }

    public Member(String name, String pass) {
        super(name, pass);
        libraryCardNumber = UUID.randomUUID();
    }

    public UUID getId() {
        return libraryCardNumber;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Library Card Number: " + libraryCardNumber);
    }

}