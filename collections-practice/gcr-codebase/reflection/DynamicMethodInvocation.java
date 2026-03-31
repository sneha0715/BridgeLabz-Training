import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return (double) a / b;
    }
    
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        return a % b;
    }
}

public class DynamicMethodInvocation {
    
    public static void invokeMethod(String methodName, int num1, int num2) throws Exception {
        MathOperations mathOps = new MathOperations();
        Class<?> clazz = MathOperations.class;
        
        try {
            Method[] methods = clazz.getDeclaredMethods();
            Method targetMethod = null;
            
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    targetMethod = method;
                    break;
                }
            }
            
            if (targetMethod == null) {
                System.out.println("Method '" + methodName + "' not found!");
                return;
            }
            
            Object result = targetMethod.invoke(mathOps, num1, num2);
            System.out.println(methodName + "(" + num1 + ", " + num2 + ") = " + result);
            
        } catch (InvocationTargetException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Dynamic Method Invocation ===\n");
        System.out.println("Available methods: add, subtract, multiply, divide, modulo\n");
        
        System.out.print("Enter method name: ");
        String methodName = scanner.nextLine().trim();
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.println();
        invokeMethod(methodName, num1, num2);
        
        System.out.println("\n--- Additional Examples ---");
        invokeMethod("add", 10, 20);
        invokeMethod("subtract", 50, 15);
        invokeMethod("multiply", 6, 7);
        invokeMethod("divide", 100, 4);
        invokeMethod("modulo", 25, 7);
        
        scanner.close();
    }
}
