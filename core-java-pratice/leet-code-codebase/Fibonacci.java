public class Fibonacci {
    public static void main(String[] args) {

        int n = 10;   // number of terms
        int f = 0, s = 1;

        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(f + " ");

            int next = f + s;
            f = s;
            s = next;
        }
    }
}
