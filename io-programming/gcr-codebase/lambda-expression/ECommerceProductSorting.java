import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ECommerceProductSorting {
  static class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String name, double price, double rating, double discount) {
      this.name = name;
      this.price = price;
      this.rating = rating;
      this.discount = discount;
    }

    @Override
    public String toString() {
      return name + " | price=" + price + " | rating=" + rating + " | discount=" + discount;
    }
  }

  public static void main(String[] args) {
    List<Product> products = new ArrayList<>();
    products.add(new Product("Sneakers", 79.99, 4.6, 10));
    products.add(new Product("Backpack", 49.50, 4.2, 25));
    products.add(new Product("Headphones", 129.00, 4.8, 15));
    products.add(new Product("Water Bottle", 19.99, 4.1, 30));

    sortForCampaign(products, "price");
    sortForCampaign(products, "rating");
    sortForCampaign(products, "discount");
  }

  static void sortForCampaign(List<Product> products, String campaign) {
    Comparator<Product> comparator;
    if ("price".equalsIgnoreCase(campaign)) {
      comparator = (a, b) -> Double.compare(a.price, b.price);
    } else if ("rating".equalsIgnoreCase(campaign)) {
      comparator = (a, b) -> Double.compare(b.rating, a.rating);
    } else {
      comparator = (a, b) -> Double.compare(b.discount, a.discount);
    }

    products.sort(comparator);
    System.out.println("Campaign: " + campaign);
    for (Product p : products) {
      System.out.println(p);
    }
    System.out.println();
  }
}
