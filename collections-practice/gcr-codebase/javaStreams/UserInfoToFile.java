import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInfoToFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            FileWriter writer = new FileWriter("user_info.txt");
            writer.write("Name: " + name + System.lineSeparator());
            writer.write("Age: " + age + System.lineSeparator());
            writer.write("Favorite Programming Language: " + language);
            writer.close();

            System.out.println("Information saved to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file.");
        }
    }
}
