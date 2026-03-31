import java.util.Arrays;
import java.util.List;

public class PatientIdPrinting {
  public static void main(String[] args) {
    List<String> patientIds = Arrays.asList("P-1001", "P-1002", "P-1050", "P-1107");
    patientIds.forEach(System.out::println);
  }
}
