import java.util.ArrayList;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

interface FareCalculator {
    double calculateFare(double distance);
}

class NormalFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

class PeakFare implements FareCalculator {
    @Override
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

class User {
    String name;
    User(String name) {
        this.name = name;
    }
}

class Driver {
    String name;
    boolean isAvailable = true;
    Driver(String name) {
        this.name = name;
    }
}

class Ride {
    User user;
    Driver driver;
    double fare;
    Ride(User user, Driver driver, double fare) {
        this.user = user;
        this.driver = driver;
        this.fare = fare;
    }
}

public class CabBookingSystem {
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ride> rideHistory = new ArrayList<>();
   
    public static Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable) {
                d.isAvailable = false;
                return d;
            }
        }
        throw new NoDriverAvailableException("No drivers available at the moment.");
    }
   
    public static void bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {
        Driver driver = assignDriver();
        double fare = fareCalculator.calculateFare(distance);
        Ride ride = new Ride(user, driver, fare);
        rideHistory.add(ride);
        System.out.println("Ride booked for " + user.name);
        System.out.println("Driver: " + driver.name);
        System.out.println("Fare: ₹" + fare);
    }
  
    public static void displayRideHistory() {
        System.out.println("\n---- Ride History ----");
        for (Ride r : rideHistory) {
            System.out.println(r.user.name + " | Driver: " + r.driver.name + " | Fare: ₹" + r.fare);
        }
    }
    public static void main(String[] args) {
        drivers.add(new Driver("Ramesh"));
        drivers.add(new Driver("Suresh"));
        User user = new User("Amit");
        try {
            bookRide(user, 5, new NormalFare());
            bookRide(user, 3, new PeakFare());
        } catch (NoDriverAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        displayRideHistory();
    }
}
