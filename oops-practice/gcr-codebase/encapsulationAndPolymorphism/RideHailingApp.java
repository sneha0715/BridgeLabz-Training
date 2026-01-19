package encapsulationAndPolymorphism;
import java.util.*;

public class RideHailingApp {

    public static void main(String[] args) {

        List<Vehicle> rides = new ArrayList<>();

        rides.add(new Car("V101", "Amit", 15));
        rides.add(new Bike("V202", "Neha", 10));
        rides.add(new Auto("V303", "Ravi", 12));

        double distance = 10; // km

        for (Vehicle v : rides) {

            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));

            GPS gps = (GPS) v;
            System.out.println("Current Location: " + gps.getCurrentLocation());
            gps.updateLocation("Downtown");
            System.out.println("Updated Location: " + gps.getCurrentLocation());

        }
    }
}

abstract class Vehicle {

    private String vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per km: " + ratePerKm);
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {

    private String currentLocation = "Unknown";

    public Car(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return ratePerKm * distance;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        currentLocation = location;
    }
}

class Bike extends Vehicle implements GPS {

    private String currentLocation = "Unknown";

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return ratePerKm * distance * 0.9;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        currentLocation = location;
    }
}

class Auto extends Vehicle implements GPS {

    private String currentLocation = "Unknown";

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return ratePerKm * distance * 1.1; 
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String location) {
        currentLocation = location;
    }
}
