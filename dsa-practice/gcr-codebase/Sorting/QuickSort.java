import java.util.*;
public class QuickSort {

  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];

    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
  }

  static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of products:");
    int n = sc.nextInt();
    
    int[] prices = new int[n];
    System.out.println("Enter the product prices:");
    for (int i = 0; i < n; i++) {
      prices[i] = sc.nextInt();
    }
    
    System.out.println("\nOriginal Product Prices:");
    printArray(prices);
    
    quickSort(prices, 0, n - 1);
    
    System.out.println("Sorted Product Prices (Ascending Order):");
    printArray(prices);
  }
}
