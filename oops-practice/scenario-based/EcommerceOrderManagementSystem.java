//product class
class Product{
  String productID;
  String name;
  double price;

  public Product(String productID, String name, double price){
    this.productID = productID;
    this.name = name;
    this.price = price;
  }
}

//customer class
class Customer{
  String customerID;
  String name;

  public Customer(String customerID, String name){
    this.customerID = customerID;
    this.name = name;
  }
}

//order class
class Order{
  String orderID;
  Customer customer;
  Product product;
  String status;

  public Order(String orderID, Customer customer, Product product){
    this.orderID = orderID;
    this.customer = customer;
    this.product = product;
  }

  void placeOrder(Payment payment){
     try{
      payment.pay(product.price);
      status="Confirmed";
      System.out.println("Order "+orderID+" placed successfully!");
     }catch(PaymentFailedException e){
        status="Failed";
        System.out.println("Order Failed: " +e.getMessage());
     }
  }

  void cancelOrder(){
    if(status.equals("Confirmed")){
      status="Cancelled";
      System.out.println("Order "+ orderID +" Cancelled");
    }else{
      System.out.println("Order cannot be cancelled.");
    }
  }
}

// Custom Exception
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}
//interface
interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

class cardPayment implements Payment {
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException("Payment amount must be greater than zero.");
        }
        System.out.println("Paid " + amount + " using Card.");
    }

}
class UPIPayment implements Payment{
    @Override
    public void pay(double amount) throws PaymentFailedException{
      if(amount<=0){
        throw new PaymentFailedException("Payment amount must be greater than zero.");
      }
      System.out.println("Paid " + amount + " using UPI.");
    }

}

class walletPayment implements Payment{
  @Override
  public void pay(double amount) throws PaymentFailedException{
    if(amount>=5000){
      throw new PaymentFailedException("Wallet Balance must be less than 5000.");
    }
    System.out.println("Paid " + amount + " using Wallet.");
  }
}

public class EcommerceOrderManagementSystem {
  public static void main(String[] args) {
    Product product=new Product("P1234","Laptop",4000.0);
    Customer customer=new Customer("123s","Sneha");

    Order order1=new Order("O001",customer, product);
    Payment payment1=new cardPayment();
    order1.placeOrder(payment1);

    Order order2=new Order("O002", customer, product);
    Payment payment2=new walletPayment();
    order2.placeOrder(payment2);
  }
}
