import java.util.Random;
public class User {
    private String name;
    private int libraryCardNumber;

    public User() {
        name = " ";
        libraryCardNumber = 0;
    }

    public User(String name, int libraryCardNumber, String address) {
        this.name = name;
        this.libraryCardNumber = generateRandomLibraryCardNumber();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "Name: " + name + "\n" +
                "Library Card Number: " + libraryCardNumber + "\n";

    }
}