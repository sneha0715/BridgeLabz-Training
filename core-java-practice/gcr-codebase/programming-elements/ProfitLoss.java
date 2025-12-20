public class ProfitLoss {
  public static void main(String[] args) {
    int costPrice=129;
    int sellPrice=191;
    int profit=sellPrice-costPrice;
    double profitPercentage=profit*100.0/costPrice;
    System.out.println("The cost price is INR "+costPrice+"and selling price is INR "+sellPrice+"\nThe profit is INR "+profit+"and the profit percentage is "+profitPercentage);
  }
}
