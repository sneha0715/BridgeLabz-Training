import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String fileName = "largeLogFile.txt";
        HashMap<String, Integer> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int totalWords = map.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words: " + totalWords);
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
