import java.lang.reflect.*;

class Person {
    private int age;
    private String name;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

public class AccessPrivateField {
    
    public static void main(String[] args) throws Exception {
        Person person = new Person("John", 25);
        
        System.out.println("=== Accessing and Modifying Private Fields ===\n");
        
        Class<?> clazz = Person.class;
        
        System.out.println("Original age: " + person.getAge());
        
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        
        int originalAge = ageField.getInt(person);
        System.out.println("Original age (via reflection): " + originalAge);
        
        ageField.setInt(person, 35);
        System.out.println("Modified age (via reflection): " + ageField.getInt(person));
        
        System.out.println("\nOriginal name: " + person.getName());
        
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        
        String originalName = (String) nameField.get(person);
        System.out.println("Original name (via reflection): " + originalName);
        
        nameField.set(person, "Jane");
        System.out.println("Modified name (via reflection): " + nameField.get(person));
        
        System.out.println("\nFinal state - Name: " + person.getName() + ", Age: " + person.getAge());
    }
}
