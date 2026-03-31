import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password;

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

class JsonConverter {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField jf = field.getAnnotation(JsonField.class);
                Object value = field.get(obj);

                if (!first) {
                    json.append(", ");
                }

                json.append("\"").append(jf.name()).append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
}

public class JsonSerializationDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("Sneha", 22, "secret123");
        String json = JsonConverter.toJson(user);
        System.out.println(json);
    }
}
