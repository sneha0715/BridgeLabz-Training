import java.util.Scanner;

public class VowelsAndConsonantsDisplay {
    
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
    
    public static String[][] getCharacterTypes(String text) {
        int textLength = findStringLength(text);
        String[][] result = new String[textLength][2];
        
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }
        
        return result;
    }
    
    public static void displayCharacterTable(String[][] characterTypes) {
        System.out.println("\n========== Character Analysis ==========");
        System.out.println("Character\tType");
        System.out.println("======================================");
        
        for (int i = 0; i < characterTypes.length; i++) {
            System.out.println(characterTypes[i][0] + "\t\t" + characterTypes[i][1]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        String[][] characterTypes = getCharacterTypes(text);
        
        displayCharacterTable(characterTypes);
        
        sc.close();
    }
}
