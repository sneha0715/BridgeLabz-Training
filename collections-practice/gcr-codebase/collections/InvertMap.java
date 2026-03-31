import java.util.*;

public class InvertMap {
    
    public static <K, V> Map<V, List<K>> invertMapWithDuplicates(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();
        
        for (Map.Entry<K, V> entry : original.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            
            inverted.computeIfAbsent(value, v -> new ArrayList<>()).add(key);
        }
        
        return inverted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Invert a Map ===");
        System.out.println("Enter number of key-value pairs:");
        int n = sc.nextInt();
        sc.nextLine();
        
        Map<String, Integer> originalMap = new HashMap<>();
        
        System.out.println("Enter key-value pairs (key value):");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            originalMap.put(input[0], Integer.parseInt(input[1]));
        }
        
        Map<Integer, List<String>> invertedMap = invertMapWithDuplicates(originalMap);
        
        System.out.println("Original Map: " + originalMap);
        System.out.println("Inverted Map: " + invertedMap);
        
        sc.close();
    }
}
