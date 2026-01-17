import java.util.*;

public class BinarySearchFirstLastOccurrence {
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Binary Search: First and Last Occurrence ===");
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Enter the target element:");
        int target = sc.nextInt();
        
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        
        if (first != -1) {
            System.out.println("First occurrence at index: " + first);
            System.out.println("Last occurrence at index: " + last);
        } else {
            System.out.println("Element not found in the array.");
        }
        
        sc.close();
    }
}
