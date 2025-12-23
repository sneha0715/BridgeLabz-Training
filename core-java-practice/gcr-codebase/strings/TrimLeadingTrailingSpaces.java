import java.util.Scanner;

public class TrimLeadingTrailingSpaces {
    
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
    
    public static int[] findTrimBounds(String text) {
        int textLength = findStringLength(text);
        int startIndex = 0;
        int endIndex = textLength - 1;
        
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) != ' ') {
                startIndex = i;
                break;
            }
        }
        
        for (int i = textLength - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                endIndex = i;
                break;
            }
        }
        
        int[] bounds = new int[2];
        bounds[0] = startIndex;
        bounds[1] = endIndex;
        
        return bounds;
    }
    
    public static String createSubstringUsingCharAt(String str, int startIndex, int endIndex) {
        String substring = "";
        for (int i = startIndex; i <= endIndex; i++) {
            substring += str.charAt(i);
        }
        return substring;
    }
    
    public static boolean compareStrings(String str1, String str2) {
        if (findStringLength(str1) != findStringLength(str2)) {
            return false;
        }
        
        int length = findStringLength(str1);
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text (with leading/trailing spaces): ");
        String text = sc.nextLine();
        
        int[] bounds = findTrimBounds(text);
        String customTrimmed = createSubstringUsingCharAt(text, bounds[0], bounds[1]);
        String builtInTrimmed = text.trim();
        
        System.out.println("\nOriginal text: '" + text + "'");
        System.out.println("Length: " + findStringLength(text));
        
        System.out.println("\nTrimmed using custom method: '" + customTrimmed + "'");
        System.out.println("Length: " + findStringLength(customTrimmed));
        
        System.out.println("\nTrimmed using trim() method: '" + builtInTrimmed + "'");
        System.out.println("Length: " + findStringLength(builtInTrimmed));
        
        boolean result = compareStrings(customTrimmed, builtInTrimmed);
        
        System.out.println("\nComparison result: " + result);
        
        if (result) {
            System.out.println("Both trimming methods produced the same result!");
        } else {
            System.out.println("Trimming results differ!");
        }
        
        sc.close();
    }
}
