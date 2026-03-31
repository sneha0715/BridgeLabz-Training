import java.util.Scanner;

public class PalindromeChecker {
    
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = findStringLength(text) - 1;
        
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
    
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        
        return isPalindromeRecursive(text, start + 1, end - 1);
    }
    
    public static String reverseStringCharAt(String text) {
        int textLength = findStringLength(text);
        String reversed = "";
        
        for (int i = textLength - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        
        return reversed;
    }
    
    public static boolean isPalindromeCharArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseStringCharAt(text).toCharArray();
        
        if (original.length != reversed.length) {
            return false;
        }
        
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        System.out.println("\nOriginal string: " + text);
        
        System.out.println("\n========== Palindrome Check Results ==========");
        
        boolean iterativeResult = isPalindromeIterative(text);
        System.out.println("Logic 1 (Iterative): " + (iterativeResult ? "Palindrome" : "Not a Palindrome"));
        
        boolean recursiveResult = isPalindromeRecursive(text, 0, findStringLength(text) - 1);
        System.out.println("Logic 2 (Recursive): " + (recursiveResult ? "Palindrome" : "Not a Palindrome"));
        
        boolean charArrayResult = isPalindromeCharArray(text);
        System.out.println("Logic 3 (Character Array): " + (charArrayResult ? "Palindrome" : "Not a Palindrome"));
        
        sc.close();
    }
}
