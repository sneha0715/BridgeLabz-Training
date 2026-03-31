import java.util.*;

class Employee {
    private String name;
    private String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    
    public static Map<String, List<Employee>> groupByDept(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }
        
        return grouped;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Group Employees by Department ===");
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        sc.nextLine();
        
        List<Employee> employees = new ArrayList<>();
        
        System.out.println("Enter employee details (name department):");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            employees.add(new Employee(input[0], input[1]));
        }
        
        Map<String, List<Employee>> grouped = groupByDept(employees);
        
        System.out.println("\nEmployees grouped by department:");
        grouped.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
        
        sc.close();
    }
}
