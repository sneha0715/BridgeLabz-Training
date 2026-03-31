import java.util.*;

public class UnionAndIntersection {
    
    public static <T> Set<T> findUnion(Set<T> set1, Set<T> set2) {
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
    
    public static <T> Set<T> findIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Union and Intersection of Sets ===");
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
        
        Set<Integer> union = findUnion(set1, set2);
        Set<Integer> intersection = findIntersection(set1, set2);
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
        
        sc.close();
    }
}
