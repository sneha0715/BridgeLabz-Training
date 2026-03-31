import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);
                if (username.length() > max.value()) {
                    throw new IllegalArgumentException("Username exceeds maximum length of " + max.value());
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidationDemo {
    public static void main(String[] args) {
        User u1 = new User("Sneha");
        System.out.println("Created user: " + u1.getUsername());

        User u2 = new User("VeryLongUsername");
        System.out.println("Created user: " + u2.getUsername());
    }
}
