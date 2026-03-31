import java.util.Scanner;

public class SubstringComparison {
    
    public static String createSubstringUsingCharAt(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > str.length() || startIndex > endIndex) {
            return "";
        }
        
        String substring = "";
        for (int i = startIndex; i < endIndex; i++) {
            substring += str.charAt(i);
        }
        return substring;
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.next();
        
        System.out.print("Enter start index: ");
        int startIndex = sc.nextInt();
        
        System.out.print("Enter end index: ");
        int endIndex = sc.nextInt();
        
        String customSubstring = createSubstringUsingCharAt(text, startIndex, endIndex);
        String builtInSubstring = text.substring(startIndex, endIndex);
        
        System.out.println("Original string: " + text);
        System.out.println("Start index: " + startIndex);
        System.out.println("End index: " + endIndex);
        
        System.out.println("Substring using charAt() method: " + customSubstring);
        System.out.println("Substring using substring() method: " + builtInSubstring);
        
        boolean result = compareStrings(customSubstring, builtInSubstring);
        
        System.out.println("Comparison result: " + result);
        
        if (result) {
            System.out.println("Both substrings are equal!");
        } else {
            System.out.println("Substrings are not equal!");
        }
    }
}
