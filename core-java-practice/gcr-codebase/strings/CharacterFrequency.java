import java.util.Scanner;

public class CharacterFrequency {
    
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
    
    public static String[][] findCharacterFrequency(String text) {
        int textLength = findStringLength(text);
        int[] frequency = new int[256];
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }
        
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            if (frequency[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                frequency[ch] = 0;
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        
        String[][] charFrequency = findCharacterFrequency(text);
        
        System.out.println("\nOriginal string: " + text);
        System.out.println("\n========== Character Frequency ==========");
        System.out.println("Character\tFrequency");
        System.out.println("======================================");
        
        for (int i = 0; i < charFrequency.length; i++) {
            System.out.println(charFrequency[i][0] + "\t\t" + charFrequency[i][1]);
        }
        
        sc.close();
    }
}
