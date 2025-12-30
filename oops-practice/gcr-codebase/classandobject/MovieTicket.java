class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean isBooked;

    void bookTicket(int seat, double ticketPrice) {
        if (!isBooked) {
            seatNumber = seat;
            price = ticketPrice;
            isBooked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Ticket already booked!");
        }
    }

    void displayTicketDetails() {
        if (isBooked) {
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Ticket Price: " + price);
        } else {
            System.out.println("Ticket not booked yet.");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        t1.movieName = "Interstellar";
        t1.bookTicket(15, 250.0);
        t1.displayTicketDetails();

    }
}
