package com.sneha.repository;

import java.util.ArrayList;
import java.util.List;
import com.sneha.entity.Employee;

public class EmployeeRepository {
  private List<Employee> employees;

  public EmployeeRepository() {
    this.employees = new ArrayList<>();
    initializeEmployees();
  }

  private void initializeEmployees() {
    employees.add(new Employee(101, "Sneha"));
    employees.add(new Employee(102, "Amit"));
    employees.add(new Employee(103, "Neha"));
    employees.add(new Employee(104, "Ravi"));
    employees.add(new Employee(105, "Priya"));
  }


  public Employee getEmployeeById(int employeeId) {
    return employees.stream()
        .filter(emp -> emp.getEmployeeId() == employeeId)
        .findFirst()
        .orElse(null);
  }

  public List<Employee> getAllEmployees() {
    return new ArrayList<>(employees);
  }


  public Employee getEmployeeByName(String employeeName) {
    return employees.stream()
        .filter(emp -> emp.getEmployeeName().equalsIgnoreCase(employeeName))
        .findFirst()
        .orElse(null);
  }

  public void addEmployee(Employee employee) {
    if (!employees.contains(employee)) {
      employees.add(employee);
    }
  }


  public void updateEmployee(Employee employee) {
    Employee existing = getEmployeeById(employee.getEmployeeId());
    if (existing != null) {
      existing.setEmployeeName(employee.getEmployeeName());
      existing.setAttendanceStatus(employee.getAttendanceStatus());
      existing.setAttendancePercentage(employee.getAttendancePercentage());
    }
  }


  public void deleteEmployee(int employeeId) {
    employees.removeIf(emp -> emp.getEmployeeId() == employeeId);
  }
}
