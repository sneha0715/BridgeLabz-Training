public class Vehicles {

    static double registrationFee = 150.0;
    String ownerName;
    String vehicleType;
    final String registrationNumber;
    public Vehicles(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void displayVehicleDetails(Object obj) {
        if (obj instanceof Vehicles) {
            Vehicles v = (Vehicles) obj;
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {

        updateRegistrationFee(150.0);

        Vehicles vehicle1 = new Vehicles(
                "Honest raj",
                "Sedan",
                "ABC123"
        );

        Vehicles vehicle2 = new Vehicles(
                "Price danish",
                "SUV",
                "XYZ789"
        );

        displayVehicleDetails(vehicle1);
        System.out.println();
        displayVehicleDetails(vehicle2);
    }
}
