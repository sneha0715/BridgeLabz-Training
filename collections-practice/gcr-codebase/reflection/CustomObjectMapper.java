import java.lang.reflect.*;
import java.util.*;

class Address {
    private String street;
    private String city;
    private String zipCode;
    
    public Address() {
    }
    
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public String toString() {
        return street + ", " + city + " " + zipCode;
    }
}

class Employee {
    private String name;
    private int empId;
    private double salary;
    private String department;
    private Address address;
    
    public Employee() {
    }
    
    public Employee(String name, int empId, double salary, String department, Address address) {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.department = department;
        this.address = address;
    }
    
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }
}

public class CustomObjectMapper {
    
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        
        Field[] fields = clazz.getDeclaredFields();
        
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            
            if (properties.containsKey(fieldName)) {
                Object value = properties.get(fieldName);
                
                if (field.getType().isPrimitive() || value == null) {
                    field.set(instance, value);
                } else if (field.getType() == String.class) {
                    field.set(instance, String.valueOf(value));
                } else if (field.getType() == Integer.class || field.getType() == int.class) {
                    field.set(instance, ((Number) value).intValue());
                } else if (field.getType() == Double.class || field.getType() == double.class) {
                    field.set(instance, ((Number) value).doubleValue());
                } else if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                    field.set(instance, Boolean.parseBoolean(value.toString()));
                } else if (value instanceof Map) {
                    Object nestedObject = toObject(field.getType(), (Map<String, Object>) value);
                    field.set(instance, nestedObject);
                } else {
                    field.set(instance, value);
                }
            }
        }
        
        return instance;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Custom Object Mapper ===\n");
        
        Map<String, Object> employeeData = new HashMap<>();
        employeeData.put("name", "John Smith");
        employeeData.put("empId", 1001);
        employeeData.put("salary", 75000.50);
        employeeData.put("department", "Engineering");
        
        Map<String, Object> addressData = new HashMap<>();
        addressData.put("street", "123 Main Street");
        addressData.put("city", "San Francisco");
        addressData.put("zipCode", "94102");
        employeeData.put("address", addressData);
        
        Employee employee = toObject(Employee.class, employeeData);
        System.out.println("Mapped Employee Object:");
        System.out.println(employee);
        
        System.out.println("\n--- Another Example ---");
        
        Map<String, Object> employee2Data = new HashMap<>();
        employee2Data.put("name", "Sarah Johnson");
        employee2Data.put("empId", 1002);
        employee2Data.put("salary", 85000.00);
        employee2Data.put("department", "Management");
        
        Map<String, Object> address2Data = new HashMap<>();
        address2Data.put("street", "456 Oak Avenue");
        address2Data.put("city", "New York");
        address2Data.put("zipCode", "10001");
        employee2Data.put("address", address2Data);
        
        Employee employee2 = toObject(Employee.class, employee2Data);
        System.out.println(employee2);
    }
}
