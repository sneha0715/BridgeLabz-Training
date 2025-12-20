import java.util.Scanner;

public class CentimeterToFeetInches {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Height in cm: ");
        double heightInCM = sc.nextDouble();

        double totalInches = heightInCM / 2.54;

        int heightInFeet = (int) (totalInches / 12);
        double heightInInches = totalInches % 12;

        System.out.println(
            "Your Height in cm is " + heightInCM +
            " while in feet is " + heightInFeet +
            " and inches is " + heightInInches
        );

        sc.close();
    }
}
