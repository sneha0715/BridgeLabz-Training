import java.util.*;

public class OnlineFoodDeliverySystem {

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 350, 1));

        for (FoodItem item : order) {

            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                d.applyDiscount();
                System.out.println(d.getDiscountDetails());
            }

           
        }
    }
}

abstract class FoodItem {

    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    protected double getPrice() {
        return price;
    }

    protected int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {

    private double discount = 0;

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    public void applyDiscount() {
        discount = 50;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount Applied: " + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {

    private double discount = 0;
    private static final double EXTRA_CHARGE = 40;

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + EXTRA_CHARGE - discount;
    }

    public void applyDiscount() {
        discount = 30;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount Applied: " + discount;
    }
}
