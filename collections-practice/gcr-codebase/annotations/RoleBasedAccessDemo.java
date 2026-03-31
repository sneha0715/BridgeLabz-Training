import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class UserContext {
    private static String currentRole;

    public static void setRole(String role) {
        currentRole = role;
    }

    public static String getRole() {
        return currentRole;
    }
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully");
    }

    public void viewDashboard() {
        System.out.println("Dashboard data displayed");
    }
}

public class RoleBasedAccessDemo {
    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Method[] methods = AdminService.class.getDeclaredMethods();

        UserContext.setRole("USER");

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed ra = method.getAnnotation(RoleAllowed.class);
                if (UserContext.getRole().equals(ra.value())) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }

        UserContext.setRole("ADMIN");

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed ra = method.getAnnotation(RoleAllowed.class);
                if (UserContext.getRole().equals(ra.value())) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}
