import java.util.*;

public class FindNthFromEnd {
    
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0 || n > list.size()) {
            return null;
        }
        
        int index = list.size() - n;
        return list.get(index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Find Nth Element from the End ===");
        System.out.println("Enter number of elements:");
        int size = sc.nextInt();
        
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter the elements:");
        sc.nextLine();
        for (int i = 0; i < size; i++) {
            list.add(sc.nextLine());
        }
        
        System.out.println("Enter N (position from end):");
        int n = sc.nextInt();
        
        String result = findNthFromEnd(list, n);
        if (result != null) {
            System.out.println("Element at position " + n + " from end: " + result);
        } else {
            System.out.println("Invalid position");
        }
        
        sc.close();
    }
}
