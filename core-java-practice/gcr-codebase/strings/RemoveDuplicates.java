import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            
            if (result.indexOf(String.valueOf(current)) == -1) {
                result.append(current);
            }
        }

        System.out.println("Original: " + input);
        System.out.println("Modified: " + result.toString());
        
        sc.close();
    }
}