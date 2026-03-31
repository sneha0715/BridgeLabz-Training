import java.util.*;

public class CheckSetsEqual {
    
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Check if Two Sets Are Equal ===");
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
        System.out.println("Are sets equal? " + areSetsEqual(set1, set2));
        
        sc.close();
    }
}
