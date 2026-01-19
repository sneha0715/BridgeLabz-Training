import java.util.*;

public class SearchTest {

    static int findLinear(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    static int findBinary(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == x) return m;
            if (a[m] < x) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        int key = n - 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i;
        }

        long t1 = System.nanoTime();
        findLinear(arr, key);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        findBinary(arr, key);
        long t4 = System.nanoTime();

        System.out.println((t2 - t1) / 1_000_000.0);
        System.out.println((t4 - t3) / 1_000_000.0);
    }
}
