import java.util.Random;

public class Member extends User {
    private String libraryCardNumber;

    public Member(){
        libraryCardNumber = "";
    }
    public Member(String cardNumber, String name){
        super(name);
        libraryCardNumber = cardNumber;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    private int generateRandomLibraryCardNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Generates a 5-digit random number
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Library Card Number: "+this.libraryCardNumber);
    }


        @Override
    public String toString() {
        return "User Information:\n" +
                "Library Card Number: " + libraryCardNumber + "\n";
    }
}
