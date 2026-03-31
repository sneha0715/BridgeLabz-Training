import java.util.*;

public class ReverseListElements {
    
    public static <T> void reverseArrayList(List<T> list) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
    
    public static <T> void reverseLinkedList(LinkedList<T> list) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Reverse List Elements ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        List<Integer> arrayList = new ArrayList<>();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        
        System.out.println("Original ArrayList: " + arrayList);
        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        reverseLinkedList(linkedList);
        System.out.println("LinkedList after double reverse: " + linkedList);
        
        sc.close();
    }
}
