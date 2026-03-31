import java.util.*;

class CarNode {
    String id;
    CarNode link;

    CarNode(String id) {
        this.id = id;
        this.link = null;
    }
}

class CircularRoad {
    private CarNode start;

    void enterRoad(String id) {
        CarNode car = new CarNode(id);

        if (start == null) {
            start = car;
            car.link = start;
        } else {
            CarNode temp = start;
            while (temp.link != start) {
                temp = temp.link;
            }
            temp.link = car;
            car.link = start;
        }
        System.out.println(id + " entered roundabout");
    }

    void exitRoad() {
        if (start == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        if (start.link == start) {
            System.out.println(start.id + " exited roundabout");
            start = null;
            return;
        }

        CarNode temp = start;
        while (temp.link.link != start) {
            temp = temp.link;
        }
        System.out.println(temp.link.id + " exited roundabout");
        temp.link = start;
    }

    void displayRoad() {
        if (start == null) {
            System.out.println("No vehicles in roundabout");
            return;
        }

        System.out.print("Roundabout status: ");
        CarNode temp = start;
        do {
            System.out.print(temp.id + " -> ");
            temp = temp.link;
        } while (temp != start);
        System.out.println("START");
    }
}

class WaitingLane {
    private Queue<String> waitingCars = new ArrayDeque<>();
    private int maxSize = 4;

    void addCar(String id) {
        if (waitingCars.size() == maxSize) {
            System.out.println("Waiting lane full. " + id + " rejected");
            return;
        }
        waitingCars.offer(id);
        System.out.println(id + " added to waiting lane");
    }

    String sendCar() {
        if (waitingCars.isEmpty()) {
            System.out.println("No cars waiting");
            return null;
        }
        return waitingCars.poll();
    }
}

public class TrafficManager {
    public static void main(String[] args) {

        CircularRoad road = new CircularRoad();
        WaitingLane lane = new WaitingLane();

        lane.addCar("V-11");
        lane.addCar("V-22");
        lane.addCar("V-33");
        lane.addCar("V-44");
        lane.addCar("V-55");

        String nextCar;
        while ((nextCar = lane.sendCar()) != null) {
            road.enterRoad(nextCar);
        }

        road.displayRoad();

        road.exitRoad();
        road.displayRoad();

        road.enterRoad("V-66");
        road.displayRoad();
    }
}
