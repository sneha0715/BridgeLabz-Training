public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double costPerDay;

    public CarRental(String customerName, String carModel, int rentalDays, double costPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.costPerDay = costPerDay;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void showRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Cost per Day: $" + costPerDay);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental customRental = new CarRental("John Doe", "SUV", 5, 80.0);
        System.out.println("Custom Rental:");
        customRental.showRentalDetails();
    }
}
