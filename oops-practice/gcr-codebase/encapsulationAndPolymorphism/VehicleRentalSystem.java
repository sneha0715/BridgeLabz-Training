package encapsulationAndPolymorphism;
import java.util.*;

public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 1500));
        vehicles.add(new Bike("BIK202", 800));
        vehicles.add(new Truck("TRK303", 3000));

        int days = 3;

        for (Vehicle v : vehicles) {

            v.displayDetails();
            System.out.println("Rental Cost: " + v.calculateRentalCost(days));

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                System.out.println(i.getInsuranceDetails());
                System.out.println("Insurance Cost: " + i.calculateInsurance(days));
            }

        }
    }
}

abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    protected double rentalRate;  

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
    }
}

interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {

    private String insurancePolicyNumber = "CAR-INS-01"; // encapsulated

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

class Bike extends Vehicle implements Insurable {

    private String insurancePolicyNumber = "BIK-INS-02";

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}

class Truck extends Vehicle implements Insurable {

    private String insurancePolicyNumber = "TRK-INS-03";

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (rentalRate * days) + 500;
    }

    @Override
    public double calculateInsurance(int days) {
        return 300 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}
