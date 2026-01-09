class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head;

    void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket t = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = t;
            t.next = head;
            return;
        }

        Ticket temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = t;
        t.next = head;
    }

    void removeTicket(int id) {
        if (head == null)
            return;

        Ticket temp = head;
        Ticket prev = null;

        do {
            if (temp.ticketId == id) {
                if (temp == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByCustomer(String name) {
        if (head == null)
            return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found");
    }

    void searchByMovie(String movie) {
        if (head == null)
            return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found");
    }

    int countTickets() {
        if (head == null)
            return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    void displayTicket(Ticket t) {
        System.out.println("Ticket ID: " + t.ticketId);
        System.out.println("Customer: " + t.customerName);
        System.out.println("Movie: " + t.movieName);
        System.out.println("Seat: " + t.seatNumber);
        System.out.println("Time: " + t.bookingTime);
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Sneha", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Rahul", "Inception", "A2", "10:01 AM");
        system.addTicket(103, "Neha", "Avatar", "B5", "10:05 AM");

        system.displayTickets();

        system.searchByCustomer("Sneha");
        system.searchByMovie("Inception");

        System.out.println("Total Tickets: " + system.countTickets());

        system.removeTicket(102);
        system.displayTickets();
    }
}
