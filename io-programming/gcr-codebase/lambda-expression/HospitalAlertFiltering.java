import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HospitalAlertFiltering {
  static class Alert {
    String type;
    String message;

    Alert(String type, String message) {
      this.type = type;
      this.message = message;
    }

    @Override
    public String toString() {
      return type + ": " + message;
    }
  }

  public static void main(String[] args) {
    List<Alert> alerts = new ArrayList<>();
    alerts.add(new Alert("CRITICAL", "Heart rate dropped"));
    alerts.add(new Alert("INFO", "Medication reminder"));
    alerts.add(new Alert("WARNING", "Low oxygen saturation"));
    alerts.add(new Alert("INFO", "Daily check-in"));

    java.util.Set<String> preferred = new java.util.HashSet<>();
    preferred.add("CRITICAL");
    preferred.add("WARNING");

    Predicate<Alert> filter = alert -> preferred.contains(alert.type);
    alerts.stream().filter(filter).forEach(System.out::println);
  }
}
