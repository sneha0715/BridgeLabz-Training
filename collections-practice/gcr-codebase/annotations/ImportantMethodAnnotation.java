import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention( RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
   String level() default "HIGH";
}
class WorkFlow{
  @ImportantMethod(level="Urgent")
  public void processPayment(){
    System.out.println("Payment processing...");
  }
  @ImportantMethod
  public void generateReports(){
    System.out.println("Generating Reports...");
  }
  public void normalTask(){
    System.out.println("Normal Task Running...");
  }
}

public class ImportantMethodAnnotation {
  public static void main(String[] args) {
    WorkFlow workFlow=new WorkFlow();

    Method[] methods=WorkFlow.class.getDeclaredMethods();

    System.out.println("Important methods :-");

    for(Method method:methods){
      if(method.isAnnotationPresent(ImportantMethod.class)){
       ImportantMethod im = method.getAnnotation(ImportantMethod.class);


      System.out.println("Method name: "+method.getName());
      System.out.println("Importance: "+im.level());

      try{
       method.invoke(workFlow);
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    }
  }
}