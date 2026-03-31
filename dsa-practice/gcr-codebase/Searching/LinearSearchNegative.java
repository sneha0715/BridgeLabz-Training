import java.util.*;

public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Linear Search: Find First Negative Number ===");
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int result = findFirstNegative(arr);
        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
            System.out.println("Value: " + arr[result]);
        } else {
            System.out.println("No negative number found in the array.");
        }
        
        sc.close();
    }
}
