import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ShipmentValidator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    while (n-- > 0) {
      String input = sc.nextLine();
      String[] parts = input.split("\\|");
      boolean validated = true;
      if (!validateShipmentCode(parts[0])) {
        validated = false;
      }
      if (!validateShipmentDate(parts[1])) {
        validated = false;
      }
      if (!validateShipmentMode(parts[2])) {
        validated = false;
      }
      if (!validateShipmentWeight(parts[3])) {
        validated = false;
      }
      if (!validateBooleanStatus(parts[4])) {
        validated = false;
      }
      if (validated) {
        System.out.println("COMPLIANT RECORD");
      } else {
        System.out.println("NON-COMPLIANT RECORD");
      }
    }
  }

  private static boolean validateShipmentCode(String code) {

    if (code.length() != 11) {
      return false;
    }
    String[] splittedCode = code.split("-");
    if (!splittedCode[0].equals("SHIP")) {
      return false;
    }
    if (splittedCode[1].length() != 6) {
      return false;
    }
    if (splittedCode[1].charAt(0) == '0') {
      return false;
    }

    for (int i = 0; i < splittedCode[1].length() - 2; i++) {
      if (splittedCode[1].charAt(i) == splittedCode[1].charAt(i + 1)
          && splittedCode[1].charAt(i) == splittedCode[1].charAt(i + 2)) {
        return false;
      }
    }
    return true;
    // if(!code.matches("SHIP-[1-9][0-9]{5}")){
    // return false;
    // }
    // int count=1;
    // for(int i=5;i<)
  }

  private static boolean validateShipmentDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    try {
      LocalDate date = LocalDate.parse(dateString, formatter);
      if (date.getYear() < 2000 || date.getYear() > 2099) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static boolean validateShipmentMode(String mode) {
    if (!(mode.equals("AIR") || mode.equals("SEA") || mode.equals("ROAD") ||
        mode.equals("RAIL") || mode.equals("EXPRESS") || mode.equals("FREIGHT"))) {
      return false;
    }
    return true;
  }

  private static boolean validateShipmentWeight(String weightString) {
    Double weight = Double.parseDouble(weightString);
    if (weight <= 0) {
      return false;
    }
    if (weightString.contains(".")) {
      String[] splittedWeight = weightString.split("\\.");
      if (splittedWeight[1].length() > 2) {
        return false;
      }
    }
    if (weightString.length() > 1 && weightString.startsWith("0") && !weightString.startsWith("0.")) {
      return false;
    }
    if (weight > 999999.99) {
      return false;
    }
    return true;
  }

  private static boolean validateBooleanStatus(String status) {
    if (!(status.equals("DELIVERED") || status.equals("CANCELLED") || status.equals("IN_TRANSIT"))) {
      return false;
    }
    return true;
  }
}
