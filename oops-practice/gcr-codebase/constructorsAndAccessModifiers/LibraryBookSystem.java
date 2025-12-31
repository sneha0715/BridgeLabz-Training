public class LibraryBookSystem {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public LibraryBookSystem(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; 
    }

    public void borrowBook() {
        if (isAvailable) {
            System.out.println("You have borrowed: " + title);
            isAvailable = false;
        } else {
            System.out.println("Sorry, " + title + " is currently not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("You have returned: " + title);
    }

    public void showDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        LibraryBookSystem book1 = new LibraryBookSystem("The Alchemist", "Paulo Coelho", 12.50);
        book1.showDetails();
        System.out.println();

        book1.borrowBook();
        book1.showDetails();
        System.out.println();

        book1.borrowBook();
        System.out.println();

        book1.returnBook();
        book1.showDetails();
    }
}
