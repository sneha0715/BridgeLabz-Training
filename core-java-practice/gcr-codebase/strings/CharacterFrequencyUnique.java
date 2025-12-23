import java.util.Scanner;

public class CharacterFrequencyUnique {
    
    public static int findStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    public static char[] findUniqueCharacters(String text) {
        int textLength = findStringLength(text);
        char[] uniqueChars = new char[textLength];
        int uniqueCount = 0;
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            
            if (isUnique) {
                uniqueChars[uniqueCount] = ch;
                uniqueCount++;
            }
        }
        
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = uniqueChars[i];
        }
        
        return result;
    }
    
    public static String[][] findCharacterFrequencyFromUnique(String text) {
        int textLength = findStringLength(text);
        int[] frequency = new int[256];
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        char[] uniqueChars = findUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];
        
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        String[][] charFrequency = findCharacterFrequencyFromUnique(text);
        
        System.out.println("\nOriginal string: " + text);
        System.out.println("\n========== Character Frequency (Using Unique Characters) ==========");
        System.out.println("Character\tFrequency");
        System.out.println("======================================");
        
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i][0] + "\t\t" + charFrequency[i][1]);
        }
        
        sc.close();
    }
}
