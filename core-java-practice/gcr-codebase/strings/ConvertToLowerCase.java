import java.util.Scanner;

public class ConvertToLowerCase {
    
    public static String convertToLowerCaseCustom(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
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
        
        String customLowerCase = convertToLowerCaseCustom(text);
        String builtInLowerCase = text.toLowerCase();
        
        System.out.println("\nOriginal text: " + text);
        System.out.println("Lowercase using custom method: " + customLowerCase);
        System.out.println("Lowercase using toLowerCase() method: " + builtInLowerCase);
        
        boolean result = compareStrings(customLowerCase, builtInLowerCase);
        
        System.out.println("\nComparison result: " + result);
        
        if (result) {
            System.out.println("Both lowercase conversions are equal!");
        } else {
            System.out.println("Lowercase conversions are not equal!");
        }
        
        sc.close();
    }
}
