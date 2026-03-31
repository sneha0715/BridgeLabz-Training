
import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char continueBooking = 'y';

        while (continueBooking == 'y' || continueBooking == 'Y') {

            int ticketPrice = 0;
            int snackPrice = 0;

            System.out.println("--- Movie Ticket Booking ---");

            System.out.println("Select Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Drama");
            System.out.print("Enter choice: ");
            int movieType = sc.nextInt();

            System.out.print("Choose Seat Type (Gold/Silver): ");
            String seatType = sc.next();

            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = sc.next();

            switch (movieType) {
                case 1:
                    ticketPrice = 200;
                    break;
                case 2:
                    ticketPrice = 180;
                    break;
                case 3:
                    ticketPrice = 150;
                    break;
                default:
                    System.out.println("Invalid movie type!");
            }

            if (seatType.equalsIgnoreCase("Gold")) {
                ticketPrice += 100;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                ticketPrice += 50;
            }

            if (snacks.equalsIgnoreCase("yes")) {
                snackPrice = 80;
            }

            int totalAmount = ticketPrice + snackPrice;
            System.out.println("Total Ticket Price: ₹" + totalAmount);

            System.out.print("Book ticket for next customer? (y/n): ");
            continueBooking = sc.next().charAt(0);
        }

        System.out.println("Thank you for booking! 🎉");
        sc.close();
    }
}
