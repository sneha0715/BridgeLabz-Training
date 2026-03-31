import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class DatabaseConnection {
    private String connectionString = "jdbc:mysql://localhost:3306/mydb";
    
    public void connect() {
        System.out.println("Connected to: " + connectionString);
    }
    
    public String getConnectionString() {
        return connectionString;
    }
}

class Logger {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class UserService {
    @Inject
    private DatabaseConnection dbConnection;
    
    @Inject
    private Logger logger;
    
    public void createUser(String userName) {
        logger.log("Creating user: " + userName);
        dbConnection.connect();
        logger.log("User created successfully");
    }
    
    public void deleteUser(String userId) {
        logger.log("Deleting user: " + userId);
        dbConnection.connect();
        logger.log("User deleted");
    }
}

class OrderService {
    @Inject
    private DatabaseConnection dbConnection;
    
    @Inject
    private Logger logger;
    
    public void placeOrder(String orderId) {
        logger.log("Placing order: " + orderId);
        dbConnection.connect();
        logger.log("Order placed successfully");
    }
}

public class DependencyInjection {
    
    public static void injectDependencies(Object service) throws IllegalAccessException {
        Class<?> clazz = service.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                
                Class<?> fieldType = field.getType();
                Object dependency = createInstance(fieldType);
                
                field.set(service, dependency);
                
                System.out.println("[DI] Injected " + fieldType.getSimpleName() + 
                                 " into " + clazz.getSimpleName() + "." + field.getName());
            }
        }
    }
    
    private static Object createInstance(Class<?> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Error creating instance of " + clazz.getSimpleName());
            return null;
        }
    }
    
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("=== Dependency Injection Container ===\n");
        
        System.out.println("--- Creating UserService ---");
        UserService userService = new UserService();
        injectDependencies(userService);
        
        System.out.println("\nUsing UserService:");
        userService.createUser("john_doe");
        System.out.println();
        userService.deleteUser("user_123");
        
        System.out.println("\n--- Creating OrderService ---");
        OrderService orderService = new OrderService();
        injectDependencies(orderService);
        
        System.out.println("\nUsing OrderService:");
        orderService.placeOrder("ORD001");
    }
}
