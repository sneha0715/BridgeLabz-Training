import java.util.Arrays;
import java.util.List;

public class EmployeeNameUppercase {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("Asha", "Kiran", "Leena", "Vikram");
    names.stream().map(String::toUpperCase).forEach(System.out::println);
  }
}
