class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double itemPrice, int qty) {
        itemName = name;
        price = itemPrice;
        quantity += qty; 
        System.out.println(name + " added to cart");
    }

    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity -= qty;
            System.out.println(qty + " item(s) removed from cart");
        } else {
            System.out.println("Not enough items to remove");
        }
    }

    void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost);
        System.out.println();
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem();

        cart.addItem("Laptop", 50000.0, 1);
        cart.displayTotalCost();

        cart.addItem("Laptop", 50000.0, 1);
        cart.displayTotalCost();

        cart.removeItem(1);
        cart.displayTotalCost();
    }
}
