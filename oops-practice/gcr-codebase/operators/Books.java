public class Books {


    static String libraryTitle = "National Knowledge Library";

    String bookName;
    String writer;

    final String bookCode;

    public Books(String bookName, String writer, String bookCode) {
        this.bookName = bookName;
        this.writer = writer;
        this.bookCode = bookCode;
    }

    public static void showLibraryTitle() {
        System.out.println("Library: " + libraryTitle);
    }

    public static void printBookInfo(Object item) {
        if (item instanceof Books) {
            Books currentBook = (Books) item;
            System.out.println("Book Name : " + currentBook.bookName);
            System.out.println("Writer   : " + currentBook.writer);
            System.out.println("Book Code: " + currentBook.bookCode);
        } else {
            System.out.println("Invalid object. Not a Book.");
        }
    }

    public static void main(String[] args) {

        showLibraryTitle();

        Books firstBook = new Books(
                "Clean Code",
                "Robert C. Martin",
                "ISBN-CC-101"
        );

        printBookInfo(firstBook);
    }
}
