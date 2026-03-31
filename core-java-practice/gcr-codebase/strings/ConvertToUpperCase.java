import java.util.Scanner;

public class ConvertToUpperCase {
    
    public static String convertToUpperCaseCustom(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
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
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        String customUpperCase = convertToUpperCaseCustom(text);
        String builtInUpperCase = text.toUpperCase();
        
        System.out.println("\nOriginal text: " + text);
        System.out.println("Uppercase using custom method: " + customUpperCase);
        System.out.println("Uppercase using toUpperCase() method: " + builtInUpperCase);
        
        boolean result = compareStrings(customUpperCase, builtInUpperCase);
        
        System.out.println("\nComparison result: " + result);
        
        if (result) {
            System.out.println("Both uppercase conversions are equal!");
        } else {
            System.out.println("Uppercase conversions are not equal!");
        }
        
        sc.close();
    }
}
