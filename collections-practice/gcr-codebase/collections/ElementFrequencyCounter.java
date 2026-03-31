import java.util.*;

public class ElementFrequencyCounter {
    
    public static Map<String, Integer> countFrequency(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        
        return frequencyMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Find Frequency of Elements ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        sc.nextLine();
        
        List<String> items = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            items.add(sc.nextLine());
        }
        
        Map<String, Integer> frequency = countFrequency(items);
        
        System.out.println("Frequency Map: " + frequency);
        
        sc.close();
    }
}
