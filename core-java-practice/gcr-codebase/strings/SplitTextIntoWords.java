import java.util.Scanner;

public class SplitTextIntoWords {
    
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
    
    public static String[] splitTextIntoWords(String text) {
        int textLength = findStringLength(text);
        int spaceCount = 0;
        
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        int[] spaceIndexes = new int[spaceCount];
        int index = 0;
        
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index] = i;
                index++;
            }
        }
        
        String[] words = new String[spaceCount + 1];
        int wordIndex = 0;
        int startIndex = 0;
        
        for (int i = 0; i < spaceCount; i++) {
            String word = "";
            for (int j = startIndex; j < spaceIndexes[i]; j++) {
                word += text.charAt(j);
            }
            words[wordIndex] = word;
            wordIndex++;
            startIndex = spaceIndexes[i] + 1;
        }
        
        String lastWord = "";
        for (int i = startIndex; i < textLength; i++) {
            lastWord += text.charAt(i);
        }
        words[wordIndex] = lastWord;
        
        return words;
    }
    
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        String[] customWords = splitTextIntoWords(text);
        String[] builtInWords = text.split(" ");
        
        System.out.println("\nOriginal text: " + text);
        
        System.out.println("\nWords using custom method:");
        for (int i = 0; i < customWords.length; i++) {
            System.out.println((i + 1) + ". " + customWords[i]);
        }
        
        System.out.println("\nWords using split() method:");
        for (int i = 0; i < builtInWords.length; i++) {
            System.out.println((i + 1) + ". " + builtInWords[i]);
        }
        
        boolean result = compareStringArrays(customWords, builtInWords);
        
        System.out.println("\nComparison result: " + result);
        
        if (result) {
            System.out.println("Both methods produced the same words!");
        } else {
            System.out.println("Words differ!");
        }
        
        sc.close();
    }
}
