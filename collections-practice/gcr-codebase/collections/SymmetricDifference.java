import java.util.*;

public class SymmetricDifference {
    
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> difference = new HashSet<>(set1);
        
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        
        difference.removeAll(intersection);
        
        Set<T> temp = new HashSet<>(set2);
        temp.removeAll(intersection);
        difference.addAll(temp);
        
        return difference;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Symmetric Difference of Sets ===");
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
        
        Set<Integer> symmetricDiff = findSymmetricDifference(set1, set2);
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDiff);
        
        sc.close();
    }
}
