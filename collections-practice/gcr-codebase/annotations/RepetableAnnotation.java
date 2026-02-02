import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport{
  String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
  BugReport[] value();
}

class Software{
  @BugReport(description="null when input is empty")
  @BugReport(description = "Slow performance on large data ")
  public void processData(){
    System.out.println("Processing Data...");
  }
}
public class RepetableAnnotation {
  public static void main(String[] args) throws Exception{
    Software software=new Software();
    Method method=software.getClass().getMethod("processData");

    BugReport[] bugReports=method.getAnnotationsByType(BugReport.class);

    for(BugReport bug: bugReports){
      System.out.println("Bug Found : "+bug.description());
    }
    software.processData();
  }
}
