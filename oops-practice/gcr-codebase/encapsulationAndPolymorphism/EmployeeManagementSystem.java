import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        List<Employee3> employees = new ArrayList<>();

        FullTimeEmployee emp1 =
                new FullTimeEmployee(101, "Sneha", 50000);
        emp1.assignDepartment("IT");

        PartTimeEmployee emp2 =
                new PartTimeEmployee(102, "Aman", 500, 40);
        emp2.assignDepartment("HR");

        employees.add(emp1);
        employees.add(emp2);

        for (Employee3 emp : employees) {
            emp.displayDetails();

            if (emp instanceof Department) {
                Department dept = (Department) emp;
                System.out.println("Department: " + dept.getDepartmentDetails());
            }
        
        }
    }
}
