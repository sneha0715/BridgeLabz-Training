import java.util.*;

public class ReverseQueue {
    
    public static <T> Queue<T> reverseQueueElements(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        
        return queue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Reverse a Queue ===");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }
        
        System.out.println("Original Queue: " + queue);
        reverseQueueElements(queue);
        System.out.println("Reversed Queue: " + queue);
        
        sc.close();
    }
}
