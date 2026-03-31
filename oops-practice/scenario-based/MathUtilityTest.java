class MathUtility {

    public static long factorial(int number) {
        if (number < 0) {
            return -1; 
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int fibonacci(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int first = 0, second = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}

public class MathUtilityTest {
    public static void main(String[] args) {
        System.out.println("===== Math Utility Testing =====");

        System.out.println("Factorial of 5: " + MathUtility.factorial(5));
        System.out.println("Factorial of -3: " + MathUtility.factorial(-3));

        System.out.println("Is 7 Prime? " + MathUtility.isPrime(7));
        System.out.println("Is 1 Prime? " + MathUtility.isPrime(1));
        System.out.println("GCD of 12 and 18: " + MathUtility.gcd(12, 18));
        System.out.println("GCD of -4 and 8: " + MathUtility.gcd(-4, 8));
        System.out.println("Fibonacci(7): " + MathUtility.fibonacci(7));
        System.out.println("Fibonacci(-2): " + MathUtility.fibonacci(-2));
    }
}
