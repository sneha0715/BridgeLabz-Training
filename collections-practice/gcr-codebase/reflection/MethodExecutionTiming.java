import java.lang.reflect.*;
import java.util.*;

class StringUtils {
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
    
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
    
    public int countCharacters(String str) {
        return str.length();
    }
    
    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
}

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
    
    public double squareRoot(double num) {
        return Math.sqrt(num);
    }
    
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}

public class MethodExecutionTiming {
    
    static class ExecutionResult {
        String methodName;
        long executionTime;
        Object result;
        
        public ExecutionResult(String methodName, long executionTime, Object result) {
            this.methodName = methodName;
            this.executionTime = executionTime;
            this.result = result;
        }
        
        @Override
        public String toString() {
            return String.format("Method: %-20s | Time: %8d ns | Result: %s", 
                               methodName, executionTime, result);
        }
    }
    
    public static List<ExecutionResult> measureMethodExecutions(Object instance) throws Exception {
        List<ExecutionResult> results = new ArrayList<>();
        Class<?> clazz = instance.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            long startTime = System.nanoTime();
            
            Object result = invokeWithDefaultParams(method, instance);
            
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            
            results.add(new ExecutionResult(method.getName(), duration, result));
        }
        
        return results;
    }
    
    private static Object invokeWithDefaultParams(Method method, Object instance) throws Exception {
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        
        for (int i = 0; i < paramTypes.length; i++) {
            params[i] = getDefaultValue(paramTypes[i]);
        }
        
        return method.invoke(instance, params);
    }
    
    private static Object getDefaultValue(Class<?> type) {
        if (type == int.class) return 10;
        if (type == double.class) return 25.0;
        if (type == float.class) return 5.0f;
        if (type == long.class) return 100L;
        if (type == boolean.class) return false;
        if (type == String.class) return "TestString";
        return null;
    }
    
    public static void displayTimingReport(String className, List<ExecutionResult> results) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("Method Execution Timing Report: " + className);
        System.out.println("=".repeat(70));
        
        long totalTime = 0;
        for (ExecutionResult result : results) {
            System.out.println(result);
            totalTime += result.executionTime;
        }
        
        System.out.println("-".repeat(70));
        System.out.printf("Total Execution Time: %d ns (%.3f ms)%n", totalTime, totalTime / 1_000_000.0);
        System.out.printf("Average Time per Method: %.0f ns%n", (double) totalTime / results.size());
        System.out.println("=".repeat(70));
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Method Execution Timing Using Reflection ===");
        
        StringUtils stringUtils = new StringUtils();
        List<ExecutionResult> stringResults = measureMethodExecutions(stringUtils);
        displayTimingReport("StringUtils", stringResults);
        
        MathOperations mathOps = new MathOperations();
        List<ExecutionResult> mathResults = measureMethodExecutions(mathOps);
        displayTimingReport("MathOperations", mathResults);
        
        System.out.println("\n--- Detailed Timing Analysis ---");
        System.out.println("StringUtils Fastest Method: " + 
                         stringResults.stream().min(Comparator.comparingLong(r -> r.executionTime))
                                     .map(r -> r.methodName).orElse("N/A"));
        
        System.out.println("MathOperations Slowest Method: " + 
                         mathResults.stream().max(Comparator.comparingLong(r -> r.executionTime))
                                    .map(r -> r.methodName).orElse("N/A"));
    }
}
