import java.util.*;

public class MergeMaps {
    
    public static Map<String, Integer> mergeMapsWithSum(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> merged = new HashMap<>(map1);
        
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            merged.put(entry.getKey(), 
                      merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Merge Two Maps ===");
        System.out.println("Enter number of entries in map1:");
        int n1 = sc.nextInt();
        sc.nextLine();
        
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println("Enter entries for map1 (key value):");
        for (int i = 0; i < n1; i++) {
            String[] input = sc.nextLine().split(" ");
            map1.put(input[0], Integer.parseInt(input[1]));
        }
        
        System.out.println("Enter number of entries in map2:");
        int n2 = sc.nextInt();
        sc.nextLine();
        
        Map<String, Integer> map2 = new HashMap<>();
        System.out.println("Enter entries for map2 (key value):");
        for (int i = 0; i < n2; i++) {
            String[] input = sc.nextLine().split(" ");
            map2.put(input[0], Integer.parseInt(input[1]));
        }
        
        Map<String, Integer> merged = mergeMapsWithSum(map1, map2);
        
        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + merged);
        
        sc.close();
    }
}
