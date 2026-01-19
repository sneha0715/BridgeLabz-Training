public class StringTest {

    static void useString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
    }

    static void useBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    static void useBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
    }

    public static void main(String[] args) {
        int n = 100000;

        long t1 = System.nanoTime();
        useString(n);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        useBuilder(n);
        long t4 = System.nanoTime();

        long t5 = System.nanoTime();
        useBuffer(n);
        long t6 = System.nanoTime();

        System.out.println((t2 - t1) / 1_000_000.0);
        System.out.println((t4 - t3) / 1_000_000.0);
        System.out.println((t6 - t5) / 1_000_000.0);
    }
}
