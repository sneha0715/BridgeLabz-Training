public class SmartHomeSystem {
    public static void main(String[] args) {

        Device device = new Thermostat("TH-101", true, 24);

        device.displayStatus();
    }
}
