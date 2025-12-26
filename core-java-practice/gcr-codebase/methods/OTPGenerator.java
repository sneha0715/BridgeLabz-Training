import java.util.Arrays;
import java.util.Scanner;

public class OTPGenerator {

    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static boolean areOTPsUnique(int[] otpArray) {
        for (int i = 0; i < otpArray.length; i++) {
            for (int j = i + 1; j < otpArray.length; j++) {
                if (otpArray[i] == otpArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];

        System.out.println("Generating 10 OTPs...");
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }

        boolean unique = areOTPsUnique(otps);

        System.out.println("\n--- Validation Result ---");
        if (unique) {
            System.out.println("Success: All 10 OTPs are unique.");
        } else {
            System.out.println("Failure: Duplicate OTP detected.");
        }
    }
}
