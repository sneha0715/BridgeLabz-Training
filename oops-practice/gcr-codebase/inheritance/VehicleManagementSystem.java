public class VehicleManagementSystem {
    public static void main(String[] args) {

        Vehicle3[] vehicles = {
            new ElectricVehicle(150, "Tesla Model 3", 75),
            new PetrolVehicle(180, "Toyota Corolla", 50)
        };

        for (Vehicle3 v : vehicles) {
            v.displayInfo();
            if (v instanceof ElectricVehicle ev) {
                ev.charge();
            } else if (v instanceof PetrolVehicle pv) {
                pv.refuel();
            }

        }
    }
}
