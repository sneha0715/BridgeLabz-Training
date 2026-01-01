public class Employee {

    static String companyName = "Tech Solutions Inc.";
    static int employeeCount = 0;
    String name;
    String designation;
    final int id;
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        employeeCount++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + employeeCount);
        System.out.println("Company Name: " + companyName);
    }


    public static void printEmployeeDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("Employee ID: " + emp.id);
            System.out.println("Name: " + emp.name);
            System.out.println("Designation: " + emp.designation);
            System.out.println("Company Name: " + companyName);
        }
    }

    public static void main(String[] args) {

        Employee emp1 = new Employee(
                "Thamarai",
                101,
                "Software Engineer"
        );

        Employee emp2 = new Employee(
                "Rohan",
                102,
                "Project Manager"
        );

        displayTotalEmployees();

        printEmployeeDetails(emp1);
        System.out.println();
        printEmployeeDetails(emp2);
    }
}
