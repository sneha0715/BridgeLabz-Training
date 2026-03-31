import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
  String priority();
  String assignedTo();
}

class TaskManager{
  @TaskInfo(priority="High",assignedTo = "Sneha")
  public void completeTask(){
    System.out.println("Task is being completed..");
  }
}

public class CustomAnnotation{
  public static void main(String[] args) throws Exception {
    TaskManager taskManager=new TaskManager();
    Method method=taskManager.getClass().getMethod("completeTask");

    if(method.isAnnotationPresent(TaskInfo.class)){
      TaskInfo taskInfo=method.getAnnotation(TaskInfo.class);
      System.out.println("Priority "+taskInfo.priority());
      System.out.println("Assigned to "+taskInfo.assignedTo());
    }
    taskManager.completeTask();
  }
}
