import java.util.regex.*;
import java.util.*;

public class ExtractLink{
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern = Pattern.compile("\\bhttps?://[\\w.-]+(?:\\.[\\w.-]+)+(?:/[^\\s]*)?\\b");
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        System.out.println(String.join(", ", links));
    }
}
