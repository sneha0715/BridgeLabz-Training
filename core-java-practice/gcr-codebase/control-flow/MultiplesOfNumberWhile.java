import java.util.Scanner;

public class MultiplesOfNumberWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        
        if (number > 0 && number < 100) {
            System.out.println("Multiples of " + number + " below 100: ");
            int counter = 100;
            while (counter >= number) {
                if (counter % number == 0) {
                    System.out.print(counter + " ");
                }
                counter--;
            }
        } else {
            System.out.println("Please enter a positive integer less than 100!");
        }
        sc.close();
    }
}
