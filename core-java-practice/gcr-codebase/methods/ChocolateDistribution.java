import java.util.Scanner;

public class ChocolateDistribution {
    
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];
        
        result[0] = numberOfChocolates / numberOfChildren;
        result[1] = numberOfChocolates % numberOfChildren;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        
        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();
        
        if (numberOfChildren <= 0) {
            System.out.println("Error: Number of children must be greater than zero.");
            sc.close();
            return;
        }
        
        if (numberOfChocolates < 0) {
            System.out.println("Error: Number of chocolates cannot be negative.");
            sc.close();
            return;
        }
        
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        
        System.out.println("Each child will get: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
        
        sc.close();
    }
}
