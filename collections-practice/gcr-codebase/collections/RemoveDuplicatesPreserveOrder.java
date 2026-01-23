import java.util.*;

public class RemoveDuplicatesPreserveOrder {
    
    public static <T> List<T> removeDuplicates(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Remove Duplicates While Preserving Order ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        System.out.println("Original List: " + list);
        List<Integer> result = removeDuplicates(list);
        System.out.println("List without duplicates: " + result);
        
        sc.close();
    }
}
