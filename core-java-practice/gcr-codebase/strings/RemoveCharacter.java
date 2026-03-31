import java.util.Scanner;

public class RemoveCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        System.out.print("Enter the character to remove: ");
        char ch = sc.next().charAt(0);

        String modified = removeCharacter(str, ch);

        System.out.println("Modified String: \"" + modified + "\"");

        sc.close();
    }

    static String removeCharacter(String str, char ch) {

        String result = "";  

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                result = result + str.charAt(i); 
            }
        }

        return result;
    }
}

