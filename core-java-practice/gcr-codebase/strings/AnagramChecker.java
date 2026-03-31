import java.util.Scanner;

public class AnagramChecker {
    
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
    
    public static boolean checkAnagrams(String text1, String text2) {
        int length1 = findStringLength(text1);
        int length2 = findStringLength(text2);
        
        if (length1 != length2) {
            return false;
        }
        
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];
        
        for (int i = 0; i < length1; i++) {
            char ch = text1.charAt(i);
            frequency1[ch]++;
        }
        
        for (int i = 0; i < length2; i++) {
            char ch = text2.charAt(i);
            frequency2[ch]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String text1 = sc.nextLine();
        
        System.out.print("Enter second string: ");
        String text2 = sc.nextLine();
        
        boolean result = checkAnagrams(text1, text2);
        
        System.out.println("\nFirst string: " + text1);
        System.out.println("Second string: " + text2);
        
        System.out.println("\n========== Anagram Check Result ==========");
        
        if (result) {
            System.out.println("The strings are anagrams!");
        } else {
            System.out.println("The strings are NOT anagrams!");
        }
        
        sc.close();
    }
}
