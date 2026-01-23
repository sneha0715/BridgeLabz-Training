import java.util.*;
import java.io.*;

public class WordFrequencyCounter {
    
    public static Map<String, Integer> countWordFrequency(String filename) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase()
                                     .replaceAll("[^a-z0-9\\s]", "")
                                     .split("\\s+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Word Frequency Counter ===");
        System.out.println("Enter filename:");
        String filename = sc.nextLine();
        
        Map<String, Integer> frequency = countWordFrequency(filename);
        
        System.out.println("Word Frequencies:");
        frequency.forEach((word, count) -> 
            System.out.println(word + " : " + count)
        );
        
        sc.close();
    }
}
