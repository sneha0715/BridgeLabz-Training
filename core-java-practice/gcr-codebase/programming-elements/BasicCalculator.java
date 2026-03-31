import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first no: ");
        double number1 = sc.nextDouble();
        System.out.println("Enter second no: ");
        double number2 = sc.nextDouble();
        double add = number1 + number2;
        double subtract = number1 - number2;
        double multiply = number1 * number2;
        double divide = number1 / number2;
        System.out.println( "The addition, subtraction, multiplication and division value of 2 numbers is " + add + ", " + subtract + ", " + multiply + ", and " + divide);
    }
}
