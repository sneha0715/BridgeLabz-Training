import java.util.*;

public class SearchStructureTest {

    static boolean scan(int[] a, int key) {
        for (int v : a) {
            if (v == key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1_000_000;
        int target = n - 1;

        int[] arr = new int[n];
        Set<Integer> hash = new HashSet<>();
        Set<Integer> tree = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = i;
            hash.add(i);
            tree.add(i);
        }

        long a = System.nanoTime();
        scan(arr, target);
        long b = System.nanoTime();

        long c = System.nanoTime();
        hash.contains(target);
        long d = System.nanoTime();

        long e = System.nanoTime();
        tree.contains(target);
        long f = System.nanoTime();

        System.out.println((b - a) / 1_000_000.0);
        System.out.println((d - c) / 1_000_000.0);
        System.out.println((f - e) / 1_000_000.0);
    }
}
