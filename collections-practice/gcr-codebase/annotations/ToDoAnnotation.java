import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
  String task();
  String assignedTo();
  String priority() default "MEDIUM";
}

class Project{
  @Todo(task="login project" , assignedTo="Sneha" , priority="High")
  public void loginProject(){
    System.out.println("Login module under progress...");
  }
  @Todo(task="email notification feature" , assignedTo = "Anita")
  public void emailFeature(){
    System.out.println("Email notification feature is pendng...");
  }
  @Todo(task = "uiEnhancement" , assignedTo = "Ravi" , priority = "Low")
  public void uiEnhancement(){
    System.out.println("UI Enhancement is in progress...");
  }
}

public class ToDoAnnotation {
  public static void main(String[] args) {
    Project project=new Project();
    Method[] methods=Project.class.getDeclaredMethods();
    for(Method method:methods){
      if(method.isAnnotationPresent(Todo.class)){
        Todo todo =method.getAnnotation(Todo.class);

        System.out.println("Method name: "+method.getName());
        System.out.println("Task: "+todo.task());
        System.out.println("Assigned to: "+todo.assignedTo());
        System.out.println("Priority: "+todo.priority());
        System.out.println();
        System.out.println();
        
      }
    }
  }
}
