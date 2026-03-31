import java.lang.reflect.*;
import java.util.*;

class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private boolean inStock;
    
    public Product(String productId, String name, double price, int quantity, String category, boolean inStock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.inStock = inStock;
    }
}

class User {
    private String userId;
    private String username;
    private String email;
    private int age;
    private List<String> roles;
    
    public User(String userId, String username, String email, int age, List<String> roles) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.age = age;
        this.roles = roles;
    }
}

public class GenerateJSON {
    
    public static String toJSON(Object obj) {
        if (obj == null) {
            return "null";
        }
        
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        
        Field[] fields = clazz.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            
            try {
                String fieldName = field.getName();
                Object value = field.get(obj);
                
                json.append("\"").append(fieldName).append("\":");
                
                if (value == null) {
                    json.append("null");
                } else if (value instanceof String) {
                    json.append("\"").append(escapeJSON(value.toString())).append("\"");
                } else if (value instanceof Boolean) {
                    json.append(value);
                } else if (value instanceof Number) {
                    json.append(value);
                } else if (value instanceof List) {
                    json.append(listToJSON((List<?>) value));
                } else if (value instanceof Map) {
                    json.append(mapToJSON((Map<?, ?>) value));
                } else {
                    json.append(toJSON(value));
                }
                
                if (i < fields.length - 1) {
                    json.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        json.append("}");
        return json.toString();
    }
    
    private static String listToJSON(List<?> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item instanceof String) {
                json.append("\"").append(item).append("\"");
            } else if (item instanceof Number || item instanceof Boolean) {
                json.append(item);
            } else {
                json.append(toJSON(item));
            }
            if (i < list.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
    
    private static String mapToJSON(Map<?, ?> map) {
        StringBuilder json = new StringBuilder("{");
        Set<?> keys = map.keySet();
        int count = 0;
        for (Object key : keys) {
            Object value = map.get(key);
            json.append("\"").append(key).append("\":");
            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else if (value instanceof Number || value instanceof Boolean) {
                json.append(value);
            } else {
                json.append(toJSON(value));
            }
            if (count < keys.size() - 1) {
                json.append(",");
            }
            count++;
        }
        json.append("}");
        return json.toString();
    }
    
    private static String escapeJSON(String str) {
        return str.replace("\"", "\\\"")
                  .replace("\\", "\\\\")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r")
                  .replace("\t", "\\t");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Converting Objects to JSON Using Reflection ===\n");
        
        Product product = new Product("P001", "Laptop", 1299.99, 50, "Electronics", true);
        
        System.out.println("Product Object as JSON:");
        System.out.println(toJSON(product));
        
        System.out.println("\n--- User Object Example ---");
        
        List<String> roles = Arrays.asList("ADMIN", "USER", "EDITOR");
        User user = new User("U001", "john_doe", "john@example.com", 28, roles);
        
        System.out.println("User Object as JSON:");
        System.out.println(toJSON(user));
        
        System.out.println("\n--- Another Product ---");
        Product phone = new Product("P002", "Smartphone", 799.50, 100, "Electronics", true);
        System.out.println(toJSON(phone));
    }
}
