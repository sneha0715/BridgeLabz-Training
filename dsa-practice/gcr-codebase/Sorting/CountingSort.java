import java.util.*;
public class CountingSort {
  
  static void countingSort(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    int min = arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) min = arr[i];
      if (arr[i] > max) max = arr[i];
    }

    int range = max - min + 1;
    int[] count = new int[range];

    for (int i = 0; i < arr.length; i++) {
      count[arr[i] - min]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    int[] output = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      output[count[arr[i] - min] - 1] = arr[i];
      count[arr[i] - min]--;
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = output[i];
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
    
    int[] ages = new int[n];
    System.out.println("Enter the ages of students (range 10-18):");
    for (int i = 0; i < n; i++) {
      ages[i] = sc.nextInt();
    }
    
    System.out.println("Original Student Ages:");
    printArray(ages);
    
    countingSort(ages);
    
    System.out.println("Sorted Student Ages (Ascending Order):");
    printArray(ages);
  }
}
