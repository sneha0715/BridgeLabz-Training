class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;
    Book next;
    Book prev;

    Book(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;

    void addAtStart(int id, String title, String author, String genre, boolean status) {
        Book b = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = b;
            return;
        }

        b.next = head;
        head.prev = b;
        head = b;
    }

    void addAtEnd(int id, String title, String author, String genre, boolean status) {
        Book b = new Book(id, title, author, genre, status);

        if (tail == null) {
            head = tail = b;
            return;
        }

        tail.next = b;
        b.prev = tail;
        tail = b;
    }

    void addAtPosition(int pos, int id, String title, String author, String genre, boolean status) {
        if (pos == 1) {
            addAtStart(id, title, author, genre, status);
            return;
        }

        Book temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, status);
            return;
        }

        Book b = new Book(id, title, author, genre, status);
        b.next = temp.next;
        b.prev = temp;
        temp.next.prev = b;
        temp.next = b;
    }

    void removeById(int id) {
        Book temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found");
    }

    void updateAvailability(int id, boolean status) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        Book temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void displayBook(Book b) {
        System.out.println("Book ID: " + b.bookId);
        System.out.println("Title: " + b.title);
        System.out.println("Author: " + b.author);
        System.out.println("Genre: " + b.genre);
        System.out.println("Available: " + b.available);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addAtStart(1, "1984", "George Orwell", "Dystopian", true);
        library.addAtEnd(2, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true);
        library.addAtPosition(2, 3, "Hamlet", "William Shakespeare", "Drama", false);

        library.displayForward();
        library.displayReverse();

        library.searchByAuthor("George Orwell");
        library.updateAvailability(3, true);

        System.out.println("Total Books: " + library.countBooks());

        library.removeById(1);
        library.displayForward();
    }
}
