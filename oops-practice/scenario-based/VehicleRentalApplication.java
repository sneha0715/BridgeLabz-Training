import java.util.ArrayList;

interface IRentable {
    double calculateRent(int days);
}

class Vehicle implements IRentable {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double dailyRate;
    protected boolean isAvailable;
    
    public Vehicle(String vehicleId, String brand, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }
    
    @Override
    public double calculateRent(int days) {
        return dailyRate * days;
    }
    
    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleId + ", Brand: " + brand + ", Model: " + model + 
                         ", Daily Rate: ₹" + dailyRate + ", Available: " + isAvailable);
    }
}

class Bike extends Vehicle {
    private boolean hasHeadwind;
    
    public Bike(String vehicleId, String brand, String model, double dailyRate, boolean hasHeadwind) {
        super(vehicleId, brand, model, dailyRate);
        this.hasHeadwind = hasHeadwind;
    }
    
    @Override
    public double calculateRent(int days) {
        double rentAmount = super.calculateRent(days);
        if (hasHeadwind) {
            rentAmount += rentAmount * 0.10;
        }
        return rentAmount;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bike, Headwind Protection: " + (hasHeadwind ? "Yes" : "No"));
    }
}

class Car extends Vehicle {
    private int seats;
    
    public Car(String vehicleId, String brand, String model, double dailyRate, int seats) {
        super(vehicleId, brand, model, dailyRate);
        this.seats = seats;
    }
    
    @Override
    public double calculateRent(int days) {
        return super.calculateRent(days) + (days * 500);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car, Seats: " + seats);
    }
}

class Truck extends Vehicle {
    private double cargoCapacityInTons;
    
    public Truck(String vehicleId, String brand, String model, double dailyRate, double cargoCapacityInTons) {
        super(vehicleId, brand, model, dailyRate);
        this.cargoCapacityInTons = cargoCapacityInTons;
    }
    
    @Override
    public double calculateRent(int days) {
        return super.calculateRent(days) + (days * cargoCapacityInTons * 1000);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck, Cargo Capacity: " + cargoCapacityInTons + " tons");
    }
}

class Customer {
    String customerId;
    String name;
    String email;
    
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }
    
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name + ", Email: " + email);
    }
}

class Rental {
    String rentalId;
    Customer customer;
    Vehicle vehicle;
    int daysRented;
    double rentalCost;
    
    public Rental(String rentalId, Customer customer, Vehicle vehicle, int daysRented) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.daysRented = daysRented;
        this.rentalCost = vehicle.calculateRent(daysRented);
    }
    
    public void displayRentalDetails() {
        System.out.println("           Rental Details           ");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Customer: " + customer.name + " (ID: " + customer.customerId + ")");
        System.out.println("Vehicle: " + vehicle.brand + " " + vehicle.model);
        System.out.println("Days Rented: " + daysRented);
        System.out.println("Total Cost: ₹" + rentalCost);
        System.out.println();
    }
}

public class VehicleRentalApplication {
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();
    
    public static void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully!");
    }
    
    public static void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }
    
    public static Vehicle findAvailableVehicle(String vehicleId) {
        for (Vehicle v : vehicles) {
            if (v.vehicleId.equals(vehicleId) && v.isAvailable) {
                return v;
            }
        }
        return null;
    }
    
    public static void rentVehicle(String rentalId, Customer customer, String vehicleId, int days) {
        Vehicle vehicle = findAvailableVehicle(vehicleId);
        if (vehicle != null) {
            vehicle.isAvailable = false;
            Rental rental = new Rental(rentalId, customer, vehicle, days);
            rentals.add(rental);
            rental.displayRentalDetails();
        } else {
            System.out.println("Vehicle not available!");
        }
    }
    
    public static void returnVehicle(String vehicleId) {
        for (Vehicle v : vehicles) {
            if (v.vehicleId.equals(vehicleId)) {
                v.isAvailable = true;
                System.out.println("Vehicle returned successfully!");
                return;
            }
        }
    }
    
    public static void displayAllVehicles() {
        System.out.println("           All Vehicles           ");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
    
    public static void displayAllCustomers() {
        System.out.println("           All Customers           ");
        for (Customer c : customers) {
            c.displayInfo();
        }
        System.out.println();
    }
    
    public static void displayAllRentals() {
        System.out.println("           All Rentals           ");
        for (Rental r : rentals) {
            r.displayRentalDetails();
        }
    }
    
    public static void main(String[] args) {
        addVehicle(new Bike("V001", "Honda", "CB 350", 1000, true));
        addVehicle(new Car("V002", "Maruti", "Swift", 3000, 5));
        addVehicle(new Truck("V003", "Tata", "ACE", 5000, 2.5));
        addVehicle(new Car("V004", "Hyundai", "Creta", 4000, 5));
        
        addCustomer(new Customer("C001", "Amit Kumar", "amit@email.com"));
        addCustomer(new Customer("C002", "Priya Singh", "priya@email.com"));
        addCustomer(new Customer("C003", "Rahul Patel", "rahul@email.com"));
        
        rentVehicle("R001", customers.get(0), "V001", 5);
        rentVehicle("R002", customers.get(1), "V002", 3);
        rentVehicle("R003", customers.get(2), "V003", 7);
        
        displayAllVehicles();
        displayAllCustomers();
        displayAllRentals();
        
        System.out.println("\n--- After Return ---");
        returnVehicle("V001");
        displayAllVehicles();
    }
}
