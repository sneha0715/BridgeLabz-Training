public class FibonacciCompare {

    static int fibSlow(int n) {
        if (n < 2) return n;
        return fibSlow(n - 1) + fibSlow(n - 2);
    }

    static int fibFast(int n) {
        if (n < 2) return n;
        int x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return y;
    }

    public static void main(String[] args) {
        int n = 30;

        long t1 = System.nanoTime();
        fibSlow(n);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        fibFast(n);
        long t4 = System.nanoTime();

        System.out.println((t2 - t1) / 1_000_000.0);
        System.out.println((t4 - t3) / 1_000_000.0);
    }
}
