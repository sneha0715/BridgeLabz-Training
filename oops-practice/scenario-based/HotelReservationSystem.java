import java.util.*;

class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String msg) {
        super(msg);
    }
}

interface PricingStrategy {
    double getPrice(double price, int days);
}

class NormalPrice implements PricingStrategy {
    public double getPrice(double price, int days) {
        return price * days;
    }
}

class SeasonalPrice implements PricingStrategy {
    public double getPrice(double price, int days) {
        return (price + 500) * days;
    }
}

class Room {
    int roomNo;
    double price;
    boolean available = true;

    Room(int roomNo, double price) {
        this.roomNo = roomNo;
        this.price = price;
    }
}

class StandardRoom extends Room {
    StandardRoom(int roomNo, double price) {
        super(roomNo, price);
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int roomNo, double price) {
        super(roomNo, price);
    }
}

class Guest {
    int id;
    String name;

    Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Reservation {
    int id;
    Guest guest;
    Room room;
    int days;
    PricingStrategy pricing;

    Reservation(int id, Guest guest, Room room, int days, PricingStrategy pricing) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.days = days;
    }

    double bill() {
        return pricing.getPrice(room.price, days);
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {

        List<Room> rooms = new ArrayList<>();
        rooms.add(new StandardRoom(101, 1500));
        rooms.add(new DeluxeRoom(201, 2500));

        Guest guest = new Guest(1, "Sneha");

        try {
            Room selectedRoom = null;

            for (Room r : rooms) {
                if (r.available && r instanceof DeluxeRoom) {
                    selectedRoom = r;
                    break;
                }
            }

            if (selectedRoom == null) {
                throw new RoomNotAvailableException("Room not available");
            }

            selectedRoom.available = false;

            Reservation reservation =
                    new Reservation(1, guest, selectedRoom, 2, new SeasonalPrice());

            System.out.println("Check-in successful");
            System.out.println("Bill Amount: " + reservation.bill());

            selectedRoom.available = true;
            System.out.println("Check-out completed");

        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
