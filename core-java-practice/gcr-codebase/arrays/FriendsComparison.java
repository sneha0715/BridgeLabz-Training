import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print(names[i] + " age: ");
            ages[i] = sc.nextInt();
            
            System.out.print(names[i] + " height: ");
            heights[i] = sc.nextDouble();
        }
        
        int youngestIndex = 0;
        int tallestIndex = 0;
        
        for (int i = 0; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("\nYoungest friend: " + names[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("Tallest friend: " + names[tallestIndex] + " with height " + heights[tallestIndex]);
        
        sc.close();
    }
}
