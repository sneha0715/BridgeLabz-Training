package com.sneha.test;

import com.sneha.entity.Employee;
import com.sneha.repository.EmployeeRepository;
import com.sneha.services.EmployeeAttendanceService;

public class AttendanceTest {

  public static void main(String[] args) {
    System.out.println("========================================");
    System.out.println("UC-1: Check Employee Attendance");
    System.out.println("========================================\n");

    EmployeeRepository repository = new EmployeeRepository();

    EmployeeAttendanceService service = new EmployeeAttendanceService(repository);

    System.out.println("--- Test 1: Check Attendance for Single Employee ---");
    for (int i = 0; i < 3; i++) {
      String status = service.checkAttendance(101);
      System.out.println("Employee 101 Attendance: " + status);
    }

    System.out.println("\n--- Test 2: Check Attendance for All Employees ---");
    service.checkAttendanceForAll();

    System.out.println("All Employees After Attendance Check:");
    System.out.println("-".repeat(50));
    repository.getAllEmployees().forEach(emp -> System.out.println(emp));

    System.out.println("\n--- Test 3: Get Specific Employee Status ---");
    String status = service.getAttendanceStatus(103);
    Employee employee = repository.getEmployeeById(103);
    if (employee != null) {
      System.out.println("Employee: " + employee.getEmployeeName() + " | Status: " + status);
    }

    System.out.println("\n========================================");
    System.out.println("Test Completed Successfully!");
    System.out.println("========================================");
  }
}
