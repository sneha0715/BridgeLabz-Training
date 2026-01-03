public class EmployeeManagement {
  public static void main(String[] args) {
    Employee2 manager=new Manager("Sneha",2,1200.00,5);
    Employee2 developer=new Developer("John",3,1000.00,"Java");
    Employee2 intern=new Intern("Alice",4,800.00,3);

    manager.displayDetails();
    developer.displayDetails();
    intern.displayDetails();
  }
}
