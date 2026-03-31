import java.util.*;

public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Linear Search: Find Sentence with Specific Word ===");
        System.out.println("Enter the number of sentences:");
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }
        
        System.out.println("Enter the word to search:");
        String word = sc.nextLine();
        
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
        
        sc.close();
    }
}
