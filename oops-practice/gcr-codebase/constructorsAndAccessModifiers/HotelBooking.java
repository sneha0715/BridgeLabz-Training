public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "Unknown Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void showBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }


    public static void main(String[] args) {
        // Using default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Default Booking:");
        booking1.showBooking();

        System.out.println();

        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);
        System.out.println("Parameterized Booking:");
        booking2.showBooking();

        System.out.println();

        // Using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Copy of Booking2:");
        booking3.showBooking();
    }
}
