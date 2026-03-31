import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        final double GST_RATE = 0.05;
        double totalRevenue = 0.0;
        
        System.out.println("Welcome to Ravi's Café");
        System.out.println("Coffee Menu:");
        System.out.println("1. Espresso - Rs. 100");
        System.out.println("2. Cappuccino - Rs. 150");
        System.out.println("3. Latte - Rs. 120");
        System.out.println("4. Americano - Rs. 110");
        System.out.println("5. Macchiato - Rs. 140");
        System.out.println("Type 'exit' to finish");
        
        while (true) {
            System.out.print("Enter coffee type (1-5) or 'exit' to quit: ");
            String input = sc.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            double price = 0.0;
            String coffeeName = "";
            
            switch (input) {
                case "1":
                    price = 100.0;
                    coffeeName = "Espresso";
                    break;
                case "2":
                    price = 150.0;
                    coffeeName = "Cappuccino";
                    break;
                case "3":
                    price = 120.0;
                    coffeeName = "Latte";
                    break;
                case "4":
                    price = 110.0;
                    coffeeName = "Americano";
                    break;
                case "5":
                    price = 140.0;
                    coffeeName = "Macchiato";
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.\n");
                    continue;
            }
            
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please enter a positive number.\n");
                continue;
            }
            
            double subtotal = price * quantity;
            double gst = subtotal * GST_RATE;
            double totalBill = subtotal + gst;
            
            totalRevenue += totalBill;
            
            System.out.println("\n--- Order Receipt ---");
            System.out.println("Coffee: " + coffeeName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per unit: Rs. " + price);
            System.out.println("Subtotal: Rs. " + subtotal);
            System.out.println("GST (5%): Rs. " + String.format("%.2f", gst));
            System.out.println("Total Bill: Rs. " + String.format("%.2f", totalBill));
        }
        System.out.println("Total Revenue for the day: Rs. " + String.format("%.2f", totalRevenue));
    }
}
