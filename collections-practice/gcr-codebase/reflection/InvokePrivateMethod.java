import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
}

public class InvokePrivateMethod {
    
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        
        System.out.println("=== Invoking Private Method Using Reflection ===\n");
        
        Class<?> clazz = Calculator.class;
        
        Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);
        
        Object result = multiplyMethod.invoke(calculator, 12, 7);
        
        System.out.println("Invoking private method: multiply(12, 7)");
        System.out.println("Result: " + result);
        
        System.out.println("\n--- Additional Calculations ---");
        System.out.println("multiply(5, 8) = " + multiplyMethod.invoke(calculator, 5, 8));
        System.out.println("multiply(10, 3) = " + multiplyMethod.invoke(calculator, 10, 3));
    }
}
