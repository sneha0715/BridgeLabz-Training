import java.util.*;

public class RemoveDuplicatesStringBuilder {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to remove duplicates:");
        String str = sc.nextLine();
        String result = removeDuplicates(str);
        System.out.println("Original String: " + str);
        System.out.println("String without duplicates: " + result);
        sc.close();
    }
}
