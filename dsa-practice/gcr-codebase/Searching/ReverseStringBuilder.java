import java.util.*;

public class ReverseStringBuilder {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to reverse:");
        String str = sc.nextLine();
        String reversed = reverseString(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
        sc.close();
    }
}
