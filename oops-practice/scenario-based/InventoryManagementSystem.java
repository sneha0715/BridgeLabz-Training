import java.util.*;

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class Product {
    private int productId;
    private String productName;
    private int quantity;

    public Product(int productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int qty) {
        this.quantity = qty;
    }
}

interface AlertService {
    void checkLowStock(Product product);
}

class Inventory implements AlertService {

    private Map<Integer, Product> products;
    private final int LOW_STOCK_LIMIT = 5;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product.getProductName());
    }

    public void updateStock(int productId, int qty) throws OutOfStockException {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        if (qty < 0) {
            throw new OutOfStockException("Stock cannot be negative");
        }
        product.updateQuantity(qty);
        System.out.println("Stock updated for " + product.getProductName());
        checkLowStock(product);
    }

    public void checkLowStock(Product product) {
        if (product.getQuantity() <= LOW_STOCK_LIMIT) {
            System.out.println("Low stock alert for " + product.getProductName());
        }
    }

    public void showInventory() {
        System.out.println("\nInventory Status");
        for (Product p : products.values()) {
            System.out.println(
                    p.getProductId() + " | " +
                    p.getProductName() + " | Qty: " +
                    p.getQuantity()
            );
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(1, "Laptop", 10);
        Product p2 = new Product(2, "Keyboard", 4);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try {
            inventory.updateStock(1, 8);
            inventory.updateStock(2, 3);
            inventory.updateStock(2, -1);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }

        inventory.showInventory();
    }
}
