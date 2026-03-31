import java.util.*;

public class SortTest {

    static void bubble(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    static void merge(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            merge(a, l, m);
            merge(a, m + 1, r);
            combine(a, l, m, r);
        }
    }

    static void combine(int[] a, int l, int m, int r) {
        int[] x = Arrays.copyOfRange(a, l, m + 1);
        int[] y = Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0, j = 0, k = l;

        while (i < x.length && j < y.length) {
            a[k++] = x[i] <= y[j] ? x[i++] : y[j++];
        }
        while (i < x.length) a[k++] = x[i++];
        while (j < y.length) a[k++] = y[j++];
    }

    static void quick(int[] a, int low, int high) {
        if (low < high) {
            int p = split(a, low, high);
            quick(a, low, p - 1);
            quick(a, p + 1, high);
        }
    }

    static int split(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[high];
        a[high] = t;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] base = new Random().ints(n, 0, n).toArray();

        int[] a1 = base.clone();
        int[] a2 = base.clone();
        int[] a3 = base.clone();

        long t1 = System.nanoTime();
        bubble(a1);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        merge(a2, 0, a2.length - 1);
        long t4 = System.nanoTime();

        long t5 = System.nanoTime();
        quick(a3, 0, a3.length - 1);
        long t6 = System.nanoTime();

        System.out.println((t2 - t1) / 1_000_000.0);
        System.out.println((t4 - t3) / 1_000_000.0);
        System.out.println((t6 - t5) / 1_000_000.0);
    }
}
