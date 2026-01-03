class RestaurantPerson {
    String name;
    int id;

    RestaurantPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

class Chef extends RestaurantPerson implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking dishes specializing in " + specialty);
    }
}

class Waiter extends RestaurantPerson implements Worker {  // <-- FIXED
    int tableNumber;

    Waiter(String name, int id, int tableNumber) {
        super(name, id);
        this.tableNumber = tableNumber;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at table " + tableNumber);
    }
}
