import java.util.regex.*;

public class ValidateSocialSecurityNumber {
    public static void main(String[] args) {
        String text = "My SSN is 123-45-6789.";

        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String ssn = matcher.group();
            System.out.println("✅ \"" + ssn + "\" is valid");
        } else {
            System.out.println("❌ \"123456789\" is invalid");
        }
    }
}
