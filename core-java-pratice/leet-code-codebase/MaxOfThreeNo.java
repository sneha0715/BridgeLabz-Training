public class MaxOfThreeNo {
    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.println("Maximum number is: " + max);
    }
}
