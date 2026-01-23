import java.util.*;

public class CircularBufferSimulation {
    private int[] buffer;
    private int capacity;
    private int size;
    private int front;
    
    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.size = 0;
        this.front = 0;
    }
    
    public void insert(int value) {
        if (size < capacity) {
            int rear = (front + size) % capacity;
            buffer[rear] = value;
            size++;
        } else {
            int rear = (front + size) % capacity;
            buffer[rear] = value;
            front = (front + 1) % capacity;
        }
    }
    
    public void display() {
        if (size == 0) {
            System.out.println("Buffer is empty");
            return;
        }
        
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(buffer[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Circular Buffer Simulation ===");
        System.out.println("Enter buffer capacity:");
        int capacity = sc.nextInt();
        
        CircularBufferSimulation buffer = new CircularBufferSimulation(capacity);
        
        System.out.println("Enter number of insertions:");
        int n = sc.nextInt();
        
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            buffer.insert(val);
            System.out.print("After inserting " + val + ": ");
            buffer.display();
        }
        
        sc.close();
    }
}
