public class RestaurantSystem {
    public static void main(String[] args) {
        Worker[] workers = {
            new Chef("Sneha", 101, "Italian Cuisine"),
            new Waiter("Rahul", 102, 5)
        };

        for (Worker w : workers) {
            if (w instanceof RestaurantPerson) {
                ((RestaurantPerson) w).displayInfo();
            }
            w.performDuties();
            System.out.println("----------");
        }
    }
}
