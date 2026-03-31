import java.util.Scanner;

public class MaximumOfThree {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int a = getInput("Enter first number: ");
        int b = getInput("Enter second number: ");
        int c = getInput("Enter third number: ");

        int max = findMaximum(a, b, c);

        System.out.println("Maximum of the three numbers is: " + max);
    }

    static int getInput(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    static int findMaximum(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}
