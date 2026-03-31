import java.io.*;

public class ReadSpeedCheck {

    static void charRead(String file) throws Exception {
        Reader r = new FileReader(file);
        while (r.read() >= 0) {}
        r.close();
    }

    static void byteRead(String file) throws Exception {
        Reader r = new InputStreamReader(new FileInputStream(file));
        while (r.read() >= 0) {}
        r.close();
    }

    public static void main(String[] args) throws Exception {
        String path = "data.txt";

        long a = System.nanoTime();
        charRead(path);
        long b = System.nanoTime();

        long c = System.nanoTime();
        byteRead(path);
        long d = System.nanoTime();

        System.out.println((b - a) / 1_000_000.0);
        System.out.println((d - c) / 1_000_000.0);
    }
}
