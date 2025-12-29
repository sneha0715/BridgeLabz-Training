import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {

        int number = getInput();
        long result = calculateFactorial(number);
        displayResult(number, result);
    }
    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }
    static long calculateFactorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }

    static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
