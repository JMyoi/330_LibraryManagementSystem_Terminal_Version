public class Librarian extends User implements Library{

    public void addBook() {
        Book newBook = new Book(); // Create a new Book object
        books.add(newBook); // Add it to the library
    }

}
