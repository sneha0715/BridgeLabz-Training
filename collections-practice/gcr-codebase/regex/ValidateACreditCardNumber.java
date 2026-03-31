import java.util.regex.*;

public class ValidateACreditCardNumber {
    public static void main(String[] args) {
        String cardNumber = "5123456789012345";

        String regex = "^(4\\d{15}|5\\d{15})$";

        boolean isValid = Pattern.matches(regex, cardNumber);

        System.out.println(isValid ? "Valid Card Number" : "Invalid Card Number");
    }
}
