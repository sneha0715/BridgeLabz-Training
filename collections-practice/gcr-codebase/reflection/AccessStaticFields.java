import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "default_secret_key_12345";
    private static String DATABASE_URL = "jdbc:mysql://localhost:3306/db";
    private static int MAX_CONNECTIONS = 10;
    
    public static String getAPIKey() {
        return API_KEY;
    }
    
    public static String getDatabaseURL() {
        return DATABASE_URL;
    }
    
    public static int getMaxConnections() {
        return MAX_CONNECTIONS;
    }
}

public class AccessStaticFields {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Accessing and Modifying Static Fields ===\n");
        
        Class<?> clazz = Configuration.class;
        
        System.out.println("Initial Values:");
        System.out.println("API_KEY: " + Configuration.getAPIKey());
        System.out.println("DATABASE_URL: " + Configuration.getDatabaseURL());
        System.out.println("MAX_CONNECTIONS: " + Configuration.getMaxConnections());
        
        System.out.println("\n--- Modifying API_KEY ---");
        Field apiKeyField = clazz.getDeclaredField("API_KEY");
        apiKeyField.setAccessible(true);
        System.out.println("Current API_KEY: " + apiKeyField.get(null));
        
        apiKeyField.set(null, "production_key_9876543");
        System.out.println("Modified API_KEY: " + apiKeyField.get(null));
        System.out.println("Verified via getter: " + Configuration.getAPIKey());
        
        System.out.println("\n--- Modifying DATABASE_URL ---");
        Field dbUrlField = clazz.getDeclaredField("DATABASE_URL");
        dbUrlField.setAccessible(true);
        System.out.println("Current DATABASE_URL: " + dbUrlField.get(null));
        
        dbUrlField.set(null, "jdbc:mysql://production-server:3306/maindb");
        System.out.println("Modified DATABASE_URL: " + dbUrlField.get(null));
        System.out.println("Verified via getter: " + Configuration.getDatabaseURL());
        
        System.out.println("\n--- Modifying MAX_CONNECTIONS ---");
        Field maxConnField = clazz.getDeclaredField("MAX_CONNECTIONS");
        maxConnField.setAccessible(true);
        System.out.println("Current MAX_CONNECTIONS: " + maxConnField.getInt(null));
        
        maxConnField.setInt(null, 50);
        System.out.println("Modified MAX_CONNECTIONS: " + maxConnField.getInt(null));
        System.out.println("Verified via getter: " + Configuration.getMaxConnections());
        
        System.out.println("\n--- Summary of All Static Fields ---");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(null));
            }
        }
    }
}
