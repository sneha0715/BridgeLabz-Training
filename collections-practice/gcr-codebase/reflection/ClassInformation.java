import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformation {
    
    public static void displayClassInfo(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            
            System.out.println("\n=== Class Information for: " + className + " ===\n");
            
            System.out.println("--- CONSTRUCTORS ---");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            if (constructors.length == 0) {
                System.out.println("No constructors found.");
            } else {
                for (Constructor<?> constructor : constructors) {
                    System.out.print("Constructor: " + clazz.getSimpleName() + "(");
                    Class<?>[] params = constructor.getParameterTypes();
                    for (int i = 0; i < params.length; i++) {
                        System.out.print(params[i].getSimpleName());
                        if (i < params.length - 1) System.out.print(", ");
                    }
                    System.out.println(")");
                }
            }
            
            System.out.println("\n--- FIELDS ---");
            Field[] fields = clazz.getDeclaredFields();
            if (fields.length == 0) {
                System.out.println("No fields found.");
            } else {
                for (Field field : fields) {
                    System.out.println("Field: " + field.getType().getSimpleName() + " " + field.getName());
                }
            }
            
            System.out.println("\n--- METHODS ---");
            Method[] methods = clazz.getDeclaredMethods();
            if (methods.length == 0) {
                System.out.println("No methods found.");
            } else {
                for (Method method : methods) {
                    System.out.print("Method: " + method.getReturnType().getSimpleName() + " " + 
                                   method.getName() + "(");
                    Class<?>[] params = method.getParameterTypes();
                    for (int i = 0; i < params.length; i++) {
                        System.out.print(params[i].getSimpleName());
                        if (i < params.length - 1) System.out.print(", ");
                    }
                    System.out.println(")");
                }
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter class name (e.g., java.lang.String, java.util.ArrayList): ");
        String className = scanner.nextLine();
        
        displayClassInfo(className);
        
        scanner.close();
    }
}
