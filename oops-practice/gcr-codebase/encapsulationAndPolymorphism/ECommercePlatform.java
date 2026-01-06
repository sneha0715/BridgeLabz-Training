import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {

    public static void main(String[] args) {

        List<Product2> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 1000));

        calculateFinalPrice(products);
    }

    public static void calculateFinalPrice(List<Product2> products) {

        for (Product2 p : products) {

            double tax = 0;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Product: " + p.getName());
            System.out.println("Final Price: " + finalPrice);
        }
    }
}
