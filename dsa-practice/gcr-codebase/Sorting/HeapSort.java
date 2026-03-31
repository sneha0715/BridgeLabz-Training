import java.util.*;
public class HeapSort {

  static void heapify(int[] arr, int n, int i) {
    int largest = i;       
    int left = 2 * i + 1;     
    int right = 2 * i + 2;    

    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      
      heapify(arr, n, largest);
    }
  }
  
  static void heapSort(int[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {

      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
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
    System.out.println("Enter the number of applicants:");
    int n = sc.nextInt();
    
    int[] salaries = new int[n];
    System.out.println("Enter the salary demands:");
    for (int i = 0; i < n; i++) {
      salaries[i] = sc.nextInt();
    }
    
    System.out.println("Original Salary Demands:");
    printArray(salaries);
    
    heapSort(salaries);
    
    System.out.println("Sorted Salary Demands (Ascending Order):");
    printArray(salaries);
  }
}
