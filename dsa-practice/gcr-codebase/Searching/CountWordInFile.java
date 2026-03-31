import java.io.*;

public class CountWordInFile {
    public static int countWord(String filename, String targetWord) {
        int count = 0;
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Count Word Occurrence in File ===");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Enter the filename:");
            String filename = br.readLine();
            
            System.out.println("Enter the word to search:");
            String word = br.readLine();
            
            int count = countWord(filename, word);
            System.out.println("Word \"" + word + "\" appears " + count + " times in the file.");
            
            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
