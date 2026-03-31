import java.util.*;

public class RotateListElements {
    
    public static <T> void rotateList(List<T> list, int positions) {
        if (list.isEmpty()) return;
        
        positions = positions % list.size();
        
        if (positions == 0) return;
        
        int n = list.size();
        List<T> rotated = new ArrayList<>();
        
        for (int i = n - positions; i < n; i++) {
            rotated.add(list.get(i));
        }
        
        for (int i = 0; i < n - positions; i++) {
            rotated.add(list.get(i));
        }
        
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Rotate List Elements ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        System.out.println("Enter rotation positions:");
        int rotations = sc.nextInt();
        
        System.out.println("Original List: " + list);
        rotateList(list, rotations);
        System.out.println("Rotated List (by " + rotations + " positions): " + list);
        
        sc.close();
    }
}
