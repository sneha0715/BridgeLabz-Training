import java.util.*;

public class FindSubset {
    
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Check if Set is Subset of Another ===");
        System.out.println("Enter size of first set:");
        int size1 = sc.nextInt();
        
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter elements for set 1:");
        for (int i = 0; i < size1; i++) {
            set1.add(sc.nextInt());
        }
        
        System.out.println("Enter size of second set:");
        int size2 = sc.nextInt();
        
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter elements for set 2:");
        for (int i = 0; i < size2; i++) {
            set2.add(sc.nextInt());
        }
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Is Set 1 a subset of Set 2? " + isSubset(set1, set2));
        System.out.println("Is Set 2 a subset of Set 1? " + isSubset(set2, set1));
        
        sc.close();
    }
}
