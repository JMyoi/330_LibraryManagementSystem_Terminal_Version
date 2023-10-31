import java.util.Random;

public class Member extends User {
    private int libraryCardNumber;

    public Member(){
        libraryCardNumber = 0;
    }
    public Member(int cardNumber){
        libraryCardNumber = cardNumber;
    }

    public int getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(int libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    private int generateRandomLibraryCardNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Generates a 5-digit random number
    }

    @Override
    public String toString() {
        return "User Information:\n" +
                "Library Card Number: " + libraryCardNumber + "\n";
    }
}
