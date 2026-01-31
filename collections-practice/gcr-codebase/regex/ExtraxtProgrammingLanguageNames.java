import java.util.regex.*;
import java.util.*;

public class ExtraxtProgrammingLanguageNames {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String regex = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        System.out.println(String.join(", ", languages));
    }
}
