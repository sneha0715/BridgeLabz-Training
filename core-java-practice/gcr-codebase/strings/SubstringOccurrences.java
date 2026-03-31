import java.util.Scanner;

public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the main string: ");
        String text = sc.nextLine();
        
        System.out.print("Enter the substring to find: ");
        String sub = sc.nextLine();
        
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;

            index += sub.length(); 
        }

        System.out.println("Occurrence count: " + count);
        
        sc.close();
    }
}