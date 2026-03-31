import java.util.*;

public class InsertionSort {
  static void insertionSort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int key = arr[i]; 
      int j = i - 1;     
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  static void printArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of employees:");
    int n = sc.nextInt();
    
    int[] employeeIds = new int[n];
    System.out.println("Enter the employee IDs:");
    for (int i = 0; i < n; i++) {
      employeeIds[i] = sc.nextInt();
    }
    
    System.out.println("\nOriginal Employee IDs:");
    printArray(employeeIds);
    
    insertionSort(employeeIds);
    
    System.out.println("Sorted Employee IDs (Ascending Order):");
    printArray(employeeIds);

  }
}
