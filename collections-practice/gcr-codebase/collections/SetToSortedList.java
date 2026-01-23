import java.util.*;

public class SetToSortedList {
    
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Convert Set to Sorted List ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        
        System.out.println("Original Set: " + set);
        List<Integer> sortedList = convertToSortedList(set);
        System.out.println("Sorted List: " + sortedList);
        
        sc.close();
    }
}
