public class LibraryManagement {
    public static void main(String[] args) {

        BookLibrary book = new Author(
                "Clean Code",
                2008,
                "Robert C. Martin",
                "Software engineer and author"
        );

        book.displayInfo();
    }
}
