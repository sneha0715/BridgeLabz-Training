public class RotationalStringApp {
    // UC1: Length validation
    public static boolean lengthValidation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.length() == str2.length();
    }
    // UC2: String concatenation
    public static String stringConcatenated(String str1) {
        return str1 + str1;
    }
    // UC3: Substring check
    public static boolean isSubstring(String str1, String str2) {
        return str1.contains(str2);
    }
    // UC5: Reusable static method
    public static boolean isRotationalString(String str1, String str2) {
        if (!lengthValidation(str1, str2)) {
            return false;
        }
        String concatenatedString = stringConcatenated(str1);
        return isSubstring(concatenatedString, str2);
    }
    // UC4: Display result
    public static void main(String[] args) {
        System.out.println(isRotationalString("abcd", "cdab")); 
        System.out.println(isRotationalString("abcd", "acbd")); 
    }
}
