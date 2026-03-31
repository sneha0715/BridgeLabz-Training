import java.util.ArrayList;

class Flight {
    String flightId;
    String airline;
    String source;
    String destination;
    double ticketPrice;
    int availableSeats;
    
    public Flight(String flightId, String airline, String source, String destination, double ticketPrice, int availableSeats) {
        this.flightId = flightId;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }
    
    public void displayInfo() {
        System.out.println("Flight ID: " + flightId + ", Airline: " + airline + 
                         ", Route: " + source + " -> " + destination + 
                         ", Price: ₹" + ticketPrice + ", Available Seats: " + availableSeats);
    }
}

class Passenger {
    String passengerId;
    String name;
    String email;
    
    public Passenger(String passengerId, String name, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.email = email;
    }
    
    public void displayInfo() {
        System.out.println("Passenger ID: " + passengerId + ", Name: " + name + ", Email: " + email);
    }
}

class Booking {
    String bookingId;
    Passenger passenger;
    Flight flight;
    int seatsBooked;
    double totalCost;
    
    public Booking(String bookingId, Passenger passenger, Flight flight, int seatsBooked) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatsBooked = seatsBooked;
        this.totalCost = flight.ticketPrice * seatsBooked;
    }
    
    public void displayBookingDetails() {
        System.out.println("           Booking Confirmation           ");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.name + " (ID: " + passenger.passengerId + ")");
        System.out.println("Flight: " + flight.airline + " (" + flight.flightId + ")");
        System.out.println("Route: " + flight.source + " -> " + flight.destination);
        System.out.println("Seats Booked: " + seatsBooked);
        System.out.println("Total Cost: ₹" + totalCost);
        System.out.println();
    }
}

public class FlightBookingSystem {
    static Flight[] flights = new Flight[10];
    static int flightCount = 0;
    static ArrayList<Passenger> passengers = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    
    public static void addFlight(Flight flight) {
        if (flightCount < flights.length) {
            flights[flightCount] = flight;
            flightCount++;
            System.out.println("Flight added successfully!");
        } else {
            System.out.println("Flight list is full!");
        }
    }
    
    public static void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        System.out.println("Passenger added successfully!");
    }
    
    public static Flight searchFlight(String route) {
        String[] parts = route.toLowerCase().split("-");
        if (parts.length != 2) {
            System.out.println("Invalid route format. Use format: Source-Destination");
            return null;
        }
        
        String source = parts[0].trim();
        String destination = parts[1].trim();
        
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].source.toLowerCase().equals(source) && 
                flights[i].destination.toLowerCase().equals(destination)) {
                return flights[i];
            }
        }
        return null;
    }
    
    public static Flight searchFlightById(String flightId) {
        for (int i = 0; i < flightCount; i++) {
            if (flights[i].flightId.equalsIgnoreCase(flightId)) {
                return flights[i];
            }
        }
        return null;
    }
    
    public static void bookFlight(String bookingId, Passenger passenger, String flightId, int seats) {
        Flight flight = searchFlightById(flightId);
        
        if (flight == null) {
            System.out.println("Flight not found!");
            return;
        }
        
        if (flight.availableSeats < seats) {
            System.out.println("Not enough seats available! Available: " + flight.availableSeats);
            return;
        }
        
        flight.availableSeats -= seats;
        Booking booking = new Booking(bookingId, passenger, flight, seats);
        bookings.add(booking);
        booking.displayBookingDetails();
    }
    
    public static void cancelBooking(String bookingId) {
        for (int i = 0; i < bookings.size(); i++) {
            Booking b = bookings.get(i);
            if (b.bookingId.equals(bookingId)) {
                b.flight.availableSeats += b.seatsBooked;
                bookings.remove(i);
                System.out.println("Booking cancelled successfully! Refund: ₹" + b.totalCost);
                return;
            }
        }
        System.out.println("Booking not found!");
    }
    
    public static void displayAllFlights() {
        System.out.println("           All Available Flights           ");
        for (int i = 0; i < flightCount; i++) {
            flights[i].displayInfo();
        }
        System.out.println();
    }
    
    public static void displayAllBookings() {
        System.out.println("\n           All Bookings           ");
        for (Booking b : bookings) {
            b.displayBookingDetails();
        }
    }
    
    public static void main(String[] args) {
        addFlight(new Flight("AI101", "Air India", "Delhi", "Mumbai", 5000, 100));
        addFlight(new Flight("AI102", "Air India", "Delhi", "Bangalore", 6000, 80));
        addFlight(new Flight("SG201", "SpiceJet", "Mumbai", "Goa", 3000, 120));
        addFlight(new Flight("SG202", "SpiceJet", "Bangalore", "Chennai", 4500, 90));
        addFlight(new Flight("UK501", "Indigo", "Delhi", "Goa", 5500, 110));
        
        addPassenger(new Passenger("P001", "Raj Kumar", "raj@email.com"));
        addPassenger(new Passenger("P002", "Anjali Sharma", "anjali@email.com"));
        addPassenger(new Passenger("P003", "Vikram Singh", "vikram@email.com"));
        addPassenger(new Passenger("P004", "Neha Gupta", "neha@email.com"));
        
        displayAllFlights();
        
        System.out.println("\n--- Searching Flights ---");
        Flight searchResult = searchFlight("Delhi - Mumbai");
        if (searchResult != null) {
            System.out.println("Flight found: " + searchResult.airline + " (" + searchResult.flightId + ")");
        }
        
        System.out.println("\n--- Booking Flights ---");
        bookFlight("B001", passengers.get(0), "AI101", 2);
        bookFlight("B002", passengers.get(1), "SG201", 3);
        bookFlight("B003", passengers.get(2), "UK501", 1);
        bookFlight("B004", passengers.get(3), "AI102", 4);
        
        displayAllBookings();
        
        System.out.println(" After Cancellation ");
        cancelBooking("B001");
        
        System.out.println(" Updated Flights ");
        displayAllFlights();
    }
}
