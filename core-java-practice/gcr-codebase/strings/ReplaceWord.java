
import java.util.Scanner;

public class ReplaceWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter the new word: ");
        String newWord = sc.next();

        String result = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified Sentence: " + result);

        sc.close();
    }

    static String replaceWord(String sentence, String oldWord, String newWord) {

        String result = "";
        int i = 0;
        while (i < sentence.length()) {

            if (i + oldWord.length() <= sentence.length() &&
                    sentence.substring(i, i + oldWord.length()).equals(oldWord)) {

                result += newWord; 
                i += oldWord.length();
            } else {
                result += sentence.charAt(i);
                i++;
            }
        }

        return result;
    }
}
