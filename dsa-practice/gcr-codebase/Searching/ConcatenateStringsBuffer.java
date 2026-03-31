import java.util.*;

public class ConcatenateStringsBuffer {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();
        
        for (String str : strings) {
            sb.append(str);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings:");
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] strings = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        
        String result = concatenateStrings(strings);
        System.out.println("Concatenated String: " + result);
        sc.close();
    }
}
