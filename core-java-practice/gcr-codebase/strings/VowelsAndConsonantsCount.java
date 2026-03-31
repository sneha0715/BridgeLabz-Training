import java.util.Scanner;

public class VowelsAndConsonantsCount {
    
    public static String checkCharacterType(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            ch = Character.toLowerCase(ch);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    
    public static int[] countVowelsAndConsonants(String text) {
        int[] count = new int[2];
        int vowels = 0;
        int consonants = 0;
        
        int textLength = 0;
        try {
            while (true) {
                text.charAt(textLength);
                textLength++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            textLength = textLength;
        }
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            String type = checkCharacterType(ch);
            
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        
        count[0] = vowels;
        count[1] = consonants;
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        int[] counts = countVowelsAndConsonants(text);
        
        System.out.println("\n========== Vowels and Consonants Count ==========");
        System.out.println("Text: " + text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        
        sc.close();
    }
}
