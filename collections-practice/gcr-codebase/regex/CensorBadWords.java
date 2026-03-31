import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String patternString = "\\b(" + String.join("|", badWords) + ")\\b";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        String result = matcher.replaceAll("****");
        System.out.println(result);
    }
}
