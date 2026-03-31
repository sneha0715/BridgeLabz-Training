import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Worker {

    @LogExecutionTime
    public void smallJob() {
        for (int i = 0; i < 1_000_000; i++);
    }

    @LogExecutionTime
    public void bigJob() {
        for (int i = 0; i < 80_000_000; i++);
    }

    public void idleJob() {
        System.out.println("Idle job running");
    }
}

public class TimeCheck {
    public static void main(String[] args) throws Exception {

        Worker worker = new Worker();
        Method[] methods = Worker.class.getDeclaredMethods();

        System.out.println("Execution Time Details:\n");

        for (Method m : methods) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                m.invoke(worker);
                long end = System.nanoTime();

                long timeTaken = end - start;

                System.out.println("Method: " + m.getName());
                System.out.println("Duration: " + timeTaken + " nanoseconds");
                System.out.println();
            }
        }
    }
}
