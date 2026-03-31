import java.util.ArrayList;
public class SuppressedUncheckedExamples {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList arraylist=new ArrayList();
    arraylist.add("Sneha");
    arraylist.add(10);
    arraylist.add(10.6);

    String name=(String) arraylist.get(0);
    int number=(int) arraylist.get(1);
    double value=(double) arraylist.get(2);

    System.out.println(name);
    System.out.println(number);
    System.out.println(value);
  }
}
