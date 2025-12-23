import java.util.Scanner;

public class CharacterFrequencyNested {
    
    public static String findCharacterFrequencyNested(String text) {
        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];
        
        for (int i = 0; i < chars.length; i++) {
            frequency[i] = 1;
            
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }
        
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result += chars[i] + ":" + frequency[i] + " ";
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        String result = findCharacterFrequencyNested(text);
        
        System.out.println("\nOriginal string: " + text);
        System.out.println("\n========== Character Frequency (Using Nested Loops) ==========");
        System.out.println("Character:Frequency");
        System.out.println(result);
        
        sc.close();
    }
}
