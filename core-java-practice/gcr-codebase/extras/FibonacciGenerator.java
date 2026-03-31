
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        generateFibonacci(terms);

        sc.close();
    }

    static void generateFibonacci(int terms) {

        System.out.println("Fibonacci Sequence:");

        Stream.iterate(new int[]{0, 1},
                f -> new int[]{f[1], f[0] + f[1]})
                .limit(terms)
                .forEach(f -> System.out.print(f[0] + " "));
    }
}

