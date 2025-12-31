public class Product {
    private String productName;
    private double price;
    private static int totalProducts;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void showProductInfo() {
        System.out.println("Product: " + productName);
        System.out.println("Price: $" + price);
    }

    public static void showTotalProducts() {
        System.out.println("Total products in inventory: " + totalProducts);
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.0);
        Product product2 = new Product("Smartphone", 800.0);
        Product product3 = new Product("Headphones", 150.0);

        System.out.println("Details of Product 1:");
        product1.showProductInfo();
        System.out.println();

        System.out.println("Details of Product 2:");
        product2.showProductInfo();
        System.out.println();

        System.out.println("Details of Product 3:");
        product3.showProductInfo();
        System.out.println();

        Product.showTotalProducts();
    }
}
