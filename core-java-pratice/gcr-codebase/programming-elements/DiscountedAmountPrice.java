public class DiscountedAmountPrice {
  public static void main(String[] args) {
    int fee=125000;
    int discountPercentage=10;
    double discount=(fee*10)/100.0;
    double feePaid=fee-discount;
    System.out.println("The discount amount is INR "+fee+"and final discounted fee is INR "+feePaid);
  }
}
