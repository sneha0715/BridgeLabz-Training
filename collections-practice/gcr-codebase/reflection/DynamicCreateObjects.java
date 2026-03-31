import java.lang.reflect.*;

class Student {
    private String name;
    private int studentId;
    private String department;
    
    public Student() {
        this.name = "";
        this.studentId = 0;
        this.department = "";
    }
    
    public Student(String name, int studentId, String department) {
        this.name = name;
        this.studentId = studentId;
        this.department = department;
    }
    
    public void display() {
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", department='" + department + '\'' +
                '}');
    }
    
    public String getName() {
        return name;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    public String getDepartment() {
        return department;
    }
}

public class DynamicCreateObjects {
    
    public static <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        return constructor.newInstance();
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== Dynamically Creating Objects Without new Keyword ===\n");
        
        Student student1 = createInstance(Student.class);
        System.out.println("Instance created using default constructor:");
        student1.display();
        
        System.out.println("\n--- Using Constructor with Parameters ---");
        
        Class<?> clazz = Student.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        Student student2 = (Student) constructor.newInstance("Alice Johnson", 101, "Computer Science");
        
        System.out.println("Instance created using parameterized constructor:");
        student2.display();
        
        System.out.println("\n--- Creating Multiple Instances ---");
        Student student3 = (Student) clazz.getDeclaredConstructor(String.class, int.class, String.class)
                                        .newInstance("Bob Smith", 102, "Electronics");
        Student student4 = (Student) clazz.getDeclaredConstructor(String.class, int.class, String.class)
                                        .newInstance("Carol White", 103, "Mechanical");
        
        student3.display();
        student4.display();
    }
}
