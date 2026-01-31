import java.util.regex.*;

public class ValidateAnIPAddress {
    public static void main(String[] args) {
        String ip = "192.168.1.1";

        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +
                       "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        boolean isValid = Pattern.matches(regex, ip);

        System.out.println(isValid ? "Valid IP Address" : "Invalid IP Address");
    }
}
