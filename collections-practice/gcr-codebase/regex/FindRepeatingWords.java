import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";

        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        List<String> repeatedWords = new ArrayList<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }

        System.out.println(String.join(", ", repeatedWords));
    }
}
