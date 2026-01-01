public class Product {

    static double discount = 10.0;
    String productName;
    double price;
    int quantity;
    final String productID;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public static void processProduct(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;

            double discountedPrice = p.price - (p.price * discount / 100);

            System.out.println("Product ID: " + p.productID);
            System.out.println("Product Name: " + p.productName);
            System.out.println("Price: $" + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + discountedPrice);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        updateDiscount(10.0);

        Product product1 = new Product(
                "P001",
                "Laptop",
                1200.0,
                5
        );

        Product product2 = new Product(
                "P002",
                "Smartphone",
                800.0,
                10
        );

        processProduct(product1);
        System.out.println();
        processProduct(product2);
    }
}

