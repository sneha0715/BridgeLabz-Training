import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;
    
    public StackUsingQueues() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int value) {
        mainQueue.add(value);
    }
    
    public int pop() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }
        
        int popped = mainQueue.remove();
        
        while (!tempQueue.isEmpty()) {
            mainQueue.add(tempQueue.remove());
        }
        
        return popped;
    }
    
    public int top() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }
        
        int topElement = mainQueue.peek();
        tempQueue.add(mainQueue.remove());
        
        while (!tempQueue.isEmpty()) {
            mainQueue.add(tempQueue.remove());
        }
        
        return topElement;
    }
    
    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Stack Using Two Queues ===");
        StackUsingQueues stack = new StackUsingQueues();
        
        System.out.println("Enter number of operations:");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println("1. Push  2. Pop  3. Top  4. Exit");
            System.out.println("Enter operation:");
            int op = sc.nextInt();
            
            if (op == 1) {
                System.out.println("Enter value to push:");
                int val = sc.nextInt();
                stack.push(val);
                System.out.println(val + " pushed");
            } else if (op == 2) {
                int popped = stack.pop();
                if (popped != -1) {
                    System.out.println("Popped: " + popped);
                }
            } else if (op == 3) {
                int top = stack.top();
                if (top != -1) {
                    System.out.println("Top element: " + top);
                }
            } else if (op == 4) {
                break;
            }
        }
        
        sc.close();
    }
}
