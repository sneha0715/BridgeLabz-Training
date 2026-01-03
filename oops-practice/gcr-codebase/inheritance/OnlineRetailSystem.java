public class OnlineRetailSystem {
    public static void main(String[] args) {

        Order[] orders = {
            new Order(101, "01-01-2026"),
            new ShippedOrder(102, "02-01-2026", "TRK12345"),
            new DeliveredOrder(103, "03-01-2026", "TRK67890", "05-01-2026")
        };

        for (Order o : orders) {
            o.displayOrderDetails();
        }
    }
}
