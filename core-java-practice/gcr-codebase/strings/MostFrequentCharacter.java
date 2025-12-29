import java.util.Scanner;

public class MostFrequentCharacter {
  
    static char findMostFrequentChar(String str) {

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            freq[c]++;
        }

        int maxCount = 0;
        char mostFrequent = ' ';

        for (int i = 0; i < 256; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                mostFrequent = (char) i;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char mostFrequent = findMostFrequentChar(input);

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");

        sc.close();
    }

}

