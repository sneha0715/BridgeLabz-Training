import java.util.*;

class CartItem {
    private String productName;
    private double price;
    private int quantity;
    
    public CartItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotalPrice() {
        return price * quantity;
    }
    
    @Override
    public String toString() {
        return productName + " - Price: " + price + ", Quantity: " + quantity + 
               ", Total: " + getTotalPrice();
    }
}

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, CartItem> cartItems;
    private TreeMap<Double, String> itemsSortedByPrice;
    
    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cartItems = new LinkedHashMap<>();
        this.itemsSortedByPrice = new TreeMap<>();
    }
    
    public void addProduct(String productName, double price) {
        productPrices.put(productName, price);
    }
    
    public void addToCart(String productName, int quantity) {
        if (productPrices.containsKey(productName)) {
            double price = productPrices.get(productName);
            if (cartItems.containsKey(productName)) {
                CartItem item = cartItems.get(productName);
                item.setQuantity(item.getQuantity() + quantity);
            } else {
                cartItems.put(productName, new CartItem(productName, price, quantity));
            }
            itemsSortedByPrice.put(price, productName);
        } else {
            System.out.println("Product not found in inventory");
        }
    }
    
    public void removeFromCart(String productName) {
        CartItem removed = cartItems.remove(productName);
        if (removed != null) {
            itemsSortedByPrice.remove(removed.getPrice());
        }
    }
    
    public void displayCartInOrder() {
        System.out.println("=== Shopping Cart (In Order Added) ===");
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (CartItem item : cartItems.values()) {
                System.out.println(item);
            }
        }
    }
    
    public void displayCartSortedByPrice() {
        System.out.println("=== Items Sorted by Price ===");
        if (itemsSortedByPrice.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Map.Entry<Double, String> entry : itemsSortedByPrice.entrySet()) {
                CartItem item = cartItems.get(entry.getValue());
                System.out.println(item);
            }
        }
    }
    
    public void displayAvailableProducts() {
        System.out.println("=== Available Products ===");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
    
    public double getCartTotal() {
        return cartItems.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
    
    public int getCartItemCount() {
        return cartItems.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct("Laptop", 50000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 2000);
        cart.addProduct("Monitor", 15000);
        cart.addProduct("Headphones", 3000);
        
        boolean running = true;
        while (running) {
            System.out.println("=== Shopping Cart System ===");
            System.out.println("1. Display available products");
            System.out.println("2. Add item to cart");
            System.out.println("3. Remove item from cart");
            System.out.println("4. Display cart (in order added)");
            System.out.println("5. Display cart (sorted by price)");
            System.out.println("6. View total amount");
            System.out.println("7. View item count");
            System.out.println("8. Exit");
            System.out.println("Enter choice:");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    cart.displayAvailableProducts();
                    break;
                case 2:
                    System.out.println("Enter product name:");
                    String productName = sc.nextLine();
                    System.out.println("Enter quantity:");
                    int quantity = sc.nextInt();
                    cart.addToCart(productName, quantity);
                    System.out.println("Item added to cart");
                    break;
                case 3:
                    System.out.println("Enter product name to remove:");
                    String toRemove = sc.nextLine();
                    cart.removeFromCart(toRemove);
                    System.out.println("Item removed from cart");
                    break;
                case 4:
                    cart.displayCartInOrder();
                    break;
                case 5:
                    cart.displayCartSortedByPrice();
                    break;
                case 6:
                    System.out.println("Cart Total: $" + cart.getCartTotal());
                    break;
                case 7:
                    System.out.println("Items in cart: " + cart.getCartItemCount());
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        
        sc.close();
    }
}
