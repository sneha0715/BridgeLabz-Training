import java.util.*;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

class SmartShelf {
    private List<Book> shelf = new ArrayList<>();

    void addBook(String title) {
        shelf.add(new Book(title));
        insertionSort();
        System.out.println(title + " added to shelf");
    }

    private void insertionSort() {
        for (int i = 1; i < shelf.size(); i++) {
            Book current = shelf.get(i);
            int j = i - 1;

            while (j >= 0 && shelf.get(j).title.compareToIgnoreCase(current.title) > 0) {
                shelf.set(j + 1, shelf.get(j));
                j--;
            }
            shelf.set(j + 1, current);
        }
    }

    void displayShelf() {
        System.out.println("\nCurrent Reading List:");
        for (Book b : shelf) {
            System.out.println(b.title);
        }
    }
}

public class SmartShelfSystem {
    public static void main(String[] args) {

        SmartShelf shelf = new SmartShelf();

        shelf.addBook("Java Programming");
        shelf.addBook("Data Structures");
        shelf.addBook("Algorithms");
        shelf.addBook("Computer Networks");
        shelf.addBook("Artificial Intelligence");

        shelf.displayShelf();
    }
}
