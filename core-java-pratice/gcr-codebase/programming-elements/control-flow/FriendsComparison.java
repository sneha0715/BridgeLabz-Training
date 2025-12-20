import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.println("Enter Amar's height (in cm): ");
        int amarHeight = sc.nextInt();
        System.out.println("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.println("Enter Akbar's height (in cm): ");
        int akbarHeight = sc.nextInt();
        System.out.println("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.println("Enter Anthony's height (in cm): ");
        int anthonyHeight = sc.nextInt();
        int youngestAge = amarAge;
        String youngestFriend = "Amar";
        
        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestFriend = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestFriend = "Anthony";
        }
        int maxHeight = amarHeight;
        String tallestFriend = "Amar";
        
        if (akbarHeight > maxHeight) {
            maxHeight = akbarHeight;
            tallestFriend = "Akbar";
        }
        if (anthonyHeight > maxHeight) {
            maxHeight = anthonyHeight;
            tallestFriend = "Anthony";
        }
        System.out.println("Youngest friend: " + youngestFriend + " (Age: " + youngestAge + " years)");
        System.out.println("Tallest friend: " + tallestFriend + " (Height: " + maxHeight + " cm)");
    }
}
