import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        String input = getInput();
        boolean isPalindrome = checkPalindrome(input);
        displayResult(input, isPalindrome);
    }

    static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean checkPalindrome(String str) {

        String cleaned = str.replaceAll("\\s+", "").toLowerCase();

        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println("\"" + str + "\" is a PALINDROME.");
        } else {
            System.out.println("\"" + str + "\" is NOT a palindrome.");
        }
    }
}
