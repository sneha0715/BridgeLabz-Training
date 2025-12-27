import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        
        String[] words = sentence.split("\\s+");
        
        String longestWord = "";

        for (String word : words) {

            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        System.out.println("The longest word is: " + longestWord);
        System.out.println("Length: " + longestWord.length());
        
        sc.close();
    }
}