class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head;
    Movie tail;

    void addAtStart(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = m;
            return;
        }
        m.next = head;
        head.prev = m;
        head = m;
    }

    void addAtEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = m;
            return;
        }
        tail.next = m;
        m.prev = tail;
        tail = m;
    }

    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtStart(title, director, year, rating);
            return;
        }

        Movie temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie m = new Movie(title, director, year, rating);
        m.next = temp.next;
        m.prev = temp;
        temp.next.prev = m;
        temp.next = m;
    }

    void removeByTitle(String title) {
        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }

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

    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found");
    }

    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movie found");
    }

    void updateRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found");
    }

    void displayForward() {
        Movie temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    void printMovie(Movie m) {
      
        System.out.println("Title: " + m.title);
        System.out.println("Director: " + m.director);
        System.out.println("Year: " + m.year);
        System.out.println("Rating: " + m.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addAtStart("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("Avatar", "James Cameron", 2009, 7.9);
        list.addAtPosition(2, "Interstellar", "Christopher Nolan", 2014, 8.6);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");
        list.updateRating("Avatar", 8.2);
        list.removeByTitle("Inception");

        list.displayForward();
    }
}
