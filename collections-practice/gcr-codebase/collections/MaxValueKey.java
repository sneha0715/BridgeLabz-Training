import java.util.*;

public class MaxValueKey {
    
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null;
        }
        
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        
        return maxKey;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Find Key with Highest Value ===");
        System.out.println("Enter number of entries:");
        int n = sc.nextInt();
        sc.nextLine();
        
        Map<String, Integer> map = new HashMap<>();
        
        System.out.println("Enter key-value pairs (key value):");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            map.put(input[0], Integer.parseInt(input[1]));
        }
        
        String maxKey = findKeyWithMaxValue(map);
        
        System.out.println("Map: " + map);
        System.out.println("Key with highest value: " + maxKey + " (" + map.get(maxKey) + ")");
        
        sc.close();
    }
}
