public class BookConstructor {
    private String title;
    private String author;
    private double price;
    // Default Constructor
    public BookConstructor() {
        this.title = "No Title";
        this.author = "No Author";
        this.price = 0.0;
    }

    // Parameterized Constructor
    public BookConstructor(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Book Author: " + author);
        System.out.println("Book Price: $" + price);
    }

    public static void main(String[] args) {
        // Using default constructor
        BookConstructor defaultBook = new BookConstructor();
        defaultBook.showDetails();

        System.out.println();

        // Using parameterized constructor
        BookConstructor customBook = new BookConstructor("The Alchemist", "Paulo Coelho", 12.50);
        customBook.showDetails();
    }
}
