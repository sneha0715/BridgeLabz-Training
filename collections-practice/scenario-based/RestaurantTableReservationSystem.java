import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Reservation {
    private String customerName;
    private int tableNumber;
    private String timeSlot;

    public Reservation(String customerName, int tableNumber, String timeSlot) {
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.timeSlot = timeSlot;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}

class RestaurantReservationSystem {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    public void reserveTable(String customerName, int tableNumber, String timeSlot) throws TableAlreadyReservedException {
        if (!tables.containsKey(tableNumber)) {
            System.out.println("Table does not exist");
            return;
        }

        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(customerName, tableNumber, timeSlot));
        System.out.println("Reservation successful for " + customerName);
    }

    public void cancelReservation(String customerName, int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.getCustomerName().equalsIgnoreCase(customerName)
                    && r.getTableNumber() == tableNumber
                    && r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Reservation cancelled");
        } else {
            System.out.println("Reservation not found");
        }
    }

    public void showAvailableTables(String timeSlot) {
        Set<Integer> reservedTables = new HashSet<>();

        for (Reservation r : reservations) {
            if (r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                reservedTables.add(r.getTableNumber());
            }
        }

        System.out.println("Available tables for " + timeSlot + ":");
        for (Integer tableNumber : tables.keySet()) {
            if (!reservedTables.contains(tableNumber)) {
                System.out.println("Table " + tableNumber + " (Capacity: " + tables.get(tableNumber).getCapacity() + ")");
            }
        }
    }
}

public class RestaurantTableReservationSystem {
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 2));
        system.addTable(new Table(3, 6));

        try {
            system.reserveTable("Sneha", 1, "7PM-9PM");
            system.reserveTable("Rahul", 2, "7PM-9PM");
            system.reserveTable("Amit", 1, "7PM-9PM");
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM-9PM");

        system.cancelReservation("Sneha", 1, "7PM-9PM");

        system.showAvailableTables("7PM-9PM");
    }
}
