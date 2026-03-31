import java.util.*;

class InvalidFlightException extends Exception {
    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightUtil {

    private static final Map<String, Integer> capacityMap = new HashMap<>();
    private static final Map<String, Double> fuelCapacityMap = new HashMap<>();

    static {
        capacityMap.put("SpiceJet", 396);
        capacityMap.put("Vistara", 615);
        capacityMap.put("IndiGo", 230);
        capacityMap.put("Air Arabia", 130);

        fuelCapacityMap.put("SpiceJet", 200000.0);
        fuelCapacityMap.put("Vistara", 300000.0);
        fuelCapacityMap.put("IndiGo", 250000.0);
        fuelCapacityMap.put("Air Arabia", 150000.0);
    }

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber == null || !flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!capacityMap.containsKey(flightName)) {
            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int max = capacityMap.get(flightName);
        if (passengerCount <= 0 || passengerCount > max) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxFuel = fuelCapacityMap.get(flightName);
        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return maxFuel - currentFuelLevel;
    }
}

public class AeroVigil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");
        String input = sc.nextLine();

        try {
            String[] parts = input.split(":");
            String flightNumber = parts[0];
            String flightName = parts[1];
            int passengerCount = Integer.parseInt(parts[2]);
            double currentFuelLevel = Double.parseDouble(parts[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);
            double fuelNeeded = util.calculateFuelToFillTank(flightName, currentFuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelNeeded + " liters");
        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
    }
}
