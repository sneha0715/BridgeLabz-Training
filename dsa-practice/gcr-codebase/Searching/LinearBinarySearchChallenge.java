import java.util.*;

public class LinearBinarySearchChallenge {
    
    public static int findFirstMissingPositive(int[] arr) {
        HashSet<Integer> numSet = new HashSet<>();
        int maxNum = 0;
        
        for (int num : arr) {
            if (num > 0) {
                numSet.add(num);
                maxNum = Math.max(maxNum, num);
            }
        }
        
        for (int i = 1; i <= maxNum + 1; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }
        
        return 1;
    }
    
    public static int binarySearchTarget(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Challenge: Linear and Binary Search Combined ===");
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);
        
        System.out.println("Enter the target number to search:");
        int target = sc.nextInt();
        
        int index = binarySearchTarget(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
        
        sc.close();
    }
}
