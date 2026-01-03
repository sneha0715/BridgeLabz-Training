public class TransportSystem {
    public static void main(String[] args) {
        Vehicle2[] vehicles = new Vehicle2[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10.5);
        vehicles[2] = new Motorcycle(160, "Petrol", true);

        for (Vehicle2 v : vehicles) {
            v.displayInfo();  
        }
    }
}
