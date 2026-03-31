public class StringBuilderVsStringBuffer {
    
    public static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();
        
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        
        System.out.println("StringBuilder Time: " + timeTaken + " nanoseconds");
    }
    
    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();
        
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        
        System.out.println("StringBuffer Time: " + timeTaken + " nanoseconds");
    }

    public static void main(String[] args) {
        System.out.println("=== Performance Comparison: StringBuilder vs StringBuffer ===\n");
        System.out.println("Concatenating 1,000,000 strings...\n");
        
        testStringBuilder();
        testStringBuffer();
        
        System.out.println("\nNote: StringBuilder is typically faster as it's not synchronized.");
    }
}
