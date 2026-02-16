package com.sneha.controller;

import java.util.Scanner;
import com.sneha.entity.Employee;
import com.sneha.repository.EmployeeRepository;
import com.sneha.services.EmployeeAttendanceService;

public class EmployeeAttendanceController {
  private EmployeeRepository employeeRepository;
  private EmployeeAttendanceService attendanceService;
  private Scanner scanner;

  public EmployeeAttendanceController() {
    this.employeeRepository = new EmployeeRepository();
    this.attendanceService = new EmployeeAttendanceService(employeeRepository);
    this.scanner = new Scanner(System.in);
  }

  public void displayMenu() {
    System.out.println("\n===== Employee Wage System - Check Attendance =====");
    System.out.println("1. Check Attendance for Specific Employee");
    System.out.println("2. Check Attendance for All Employees");
    System.out.println("3. View All Employees");
    System.out.println("4. View Attendance Status");
    System.out.println("5. Exit");
    System.out.println("===================================================");
    System.out.print("Enter your choice: ");
  }

  public void checkAttendanceForEmployee() {
    System.out.print("\nEnter Employee ID: ");
    try {
      int employeeId = Integer.parseInt(scanner.nextLine().trim());
      String status = attendanceService.checkAttendance(employeeId);
      
      if (!status.equals("Employee not found!")) {
        System.out.println("Employee ID: " + employeeId + " | Attendance: " + status);
      } else {
        System.out.println(status);
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid input! Please enter a valid Employee ID.");
    }
  }

  public void checkAttendanceForAll() {
    System.out.println("\nMarking attendance for all employees...");
    attendanceService.checkAttendanceForAll();
    
    System.out.println("\nAttendance Report:");
    System.out.println("-".repeat(50));
    
    employeeRepository.getAllEmployees().forEach(emp -> 
      System.out.printf("ID: %d | Name: %-15s | Status: %s%n", 
                       emp.getEmployeeId(), 
                       emp.getEmployeeName(), 
                       emp.getAttendanceStatus())
    );
    
    System.out.println("-".repeat(50));
  }

  public void viewAllEmployees() {
    System.out.println("\nAll Employees:");
    System.out.println("-".repeat(50));
    
    employeeRepository.getAllEmployees().forEach(emp -> 
      System.out.printf("ID: %d | Name: %-15s | Status: %s%n", 
                       emp.getEmployeeId(), 
                       emp.getEmployeeName(), 
                       emp.getAttendanceStatus())
    );
    
    System.out.println("-".repeat(50));
  }

  public void viewAttendanceStatus() {
    System.out.print("\nEnter Employee ID: ");
    try {
      int employeeId = Integer.parseInt(scanner.nextLine().trim());
      Employee employee = employeeRepository.getEmployeeById(employeeId);
      
      if (employee != null) {
        System.out.println("\nAttendance Status:");
        System.out.printf("ID: %d | Name: %s | Status: %s%n", 
                         employee.getEmployeeId(), 
                         employee.getEmployeeName(), 
                         employee.getAttendanceStatus());
      } else {
        System.out.println("Employee not found!");
      }
    } catch (NumberFormatException e) {
      System.out.println("Invalid input! Please enter a valid Employee ID.");
    }
  }

  public void run() {
    boolean isRunning = true;
    
    while (isRunning) {
      displayMenu();
      try {
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
          case "1":
            checkAttendanceForEmployee();
            break;
          case "2":
            checkAttendanceForAll();
            break;
          case "3":
            viewAllEmployees();
            break;
          case "4":
            viewAttendanceStatus();
            break;
          case "5":
            System.out.println("\nThank you! Goodbye!");
            isRunning = false;
            break;
          default:
            System.out.println("Invalid choice! Please try again.");
        }
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

  public void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
