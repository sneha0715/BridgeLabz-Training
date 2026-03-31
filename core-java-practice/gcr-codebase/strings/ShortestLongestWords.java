import java.util.Scanner;

public class ShortestLongestWords {
    
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
    
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findStringLength(words[i]));
        }
        
        return result;
    }
    
    public static String[] findShortestAndLongest(String[][] wordsWithLengths) {
        int minLength = Integer.parseInt(wordsWithLengths[0][1]);
        int maxLength = Integer.parseInt(wordsWithLengths[0][1]);
        String shortest = wordsWithLengths[0][0];
        String longest = wordsWithLengths[0][0];
        
        for (int i = 1; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            
            if (length < minLength) {
                minLength = length;
                shortest = wordsWithLengths[i][0];
            }
            
            if (length > maxLength) {
                maxLength = length;
                longest = wordsWithLengths[i][0];
            }
        }
        
        String[] result = new String[2];
        result[0] = shortest;
        result[1] = longest;
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        String[] words = splitTextIntoWords(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);
        String[] result = findShortestAndLongest(wordsWithLengths);
        
        System.out.println("\n========== Word Analysis ==========");
        System.out.println("Word\t\tLength");
        System.out.println("===================================");
        
        for (int i = 0; i < wordsWithLengths.length; i++) {
            int length = Integer.parseInt(wordsWithLengths[i][1]);
            System.out.println(wordsWithLengths[i][0] + "\t\t" + length);
        }
        
        System.out.println("\n========== Results ==========");
        System.out.println("Shortest word: " + result[0] + " (length: " + findStringLength(result[0]) + ")");
        System.out.println("Longest word: " + result[1] + " (length: " + findStringLength(result[1]) + ")");
        
        sc.close();
    }
}
