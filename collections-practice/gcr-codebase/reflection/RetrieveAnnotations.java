import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
    String date() default "Unknown";
}

@Author(name = "John Developer", date = "2024-01-15")
class DatabaseService {
    public void connect() {
        System.out.println("Connected to database");
    }
    
    public void disconnect() {
        System.out.println("Disconnected from database");
    }
}

@Author(name = "Sarah Engineer")
class APIHandler {
    public void fetchData() {
        System.out.println("Fetching data from API");
    }
}

@Author(name = "Mike Designer", date = "2024-02-20")
class UIRenderer {
    public void render() {
        System.out.println("Rendering UI components");
    }
}

public class RetrieveAnnotations {
    
    public static void displayAuthorInfo(Class<?> clazz) {
        Author author = clazz.getAnnotation(Author.class);
        
        if (author != null) {
            System.out.println("Class: " + clazz.getSimpleName());
            System.out.println("  Author: " + author.name());
            System.out.println("  Date: " + author.date());
        } else {
            System.out.println("No @Author annotation found for " + clazz.getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Retrieving Annotations at Runtime ===\n");
        
        displayAuthorInfo(DatabaseService.class);
        System.out.println();
        displayAuthorInfo(APIHandler.class);
        System.out.println();
        displayAuthorInfo(UIRenderer.class);
        
        System.out.println("\n--- Scanning All Annotated Classes ---");
        
        Class<?>[] classes = {DatabaseService.class, APIHandler.class, UIRenderer.class};
        
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(Author.class)) {
                Author author = clazz.getAnnotation(Author.class);
                System.out.println(clazz.getSimpleName() + " -> " + author.name() + " (" + author.date() + ")");
            }
        }
    }
}
