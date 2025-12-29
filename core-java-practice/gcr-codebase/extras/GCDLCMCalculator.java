import java.util.Scanner;
import java.math.BigInteger;

public class GCDLCMCalculator {

    public static void main(String[] args) {

        int a = getInput("Enter first number: ");
        int b = getInput("Enter second number: ");

        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b);

        displayResult(a, b, gcd, lcm);
    }

    static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    static int calculateGCD(int x, int y) {

        BigInteger b1 = BigInteger.valueOf(x);
        BigInteger b2 = BigInteger.valueOf(y);

        return b1.gcd(b2).intValue();
    }

    static int calculateLCM(int x, int y) {

        return (x * y) / calculateGCD(x, y);
    }

    static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
