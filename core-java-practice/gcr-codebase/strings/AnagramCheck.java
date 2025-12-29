import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().replaceAll("\\s+", "").toLowerCase();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().replaceAll("\\s+", "").toLowerCase();

        boolean result = areAnagrams(str1, str2);

        if (result) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }

        sc.close();
    }

    static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}

