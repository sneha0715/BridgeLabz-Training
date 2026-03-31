import java.util.Scanner;

public class CharArrayComparison {
    
    public static char[] convertToCharArray(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void displayCharArray(char[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        char[] customCharArray = convertToCharArray(text);
        char[] builtInCharArray = text.toCharArray();
        
        System.out.println("\nOriginal string: " + text);
        
        System.out.print("Character array using custom method: ");
        displayCharArray(customCharArray);
        
        System.out.print("Character array using toCharArray() method: ");
        displayCharArray(builtInCharArray);
        
        boolean result = compareCharArrays(customCharArray, builtInCharArray);
        
        System.out.println("\nComparison result: " + result);
        
        if (result) {
            System.out.println("Both character arrays are equal!");
        } else {
            System.out.println("Character arrays are not equal!");
        }
    }
}
