import java.util.*;
public class SelectionSort {
  static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
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
    System.out.println("Enter the number of students:");
    int n = sc.nextInt();
    
    int[] scores = new int[n];
    System.out.println("Enter the exam scores:");
    for (int i = 0; i < n; i++) {
      scores[i] = sc.nextInt();
    }
    
    System.out.println("\nOriginal Exam Scores:");
    printArray(scores);
    
    selectionSort(scores);
    
    System.out.println("Sorted Exam Scores (Ascending Order):");
    printArray(scores);
  }
}
