package com.sneha.services;

import java.util.Random;
import com.sneha.entity.Employee;
import com.sneha.repository.EmployeeRepository;


public class EmployeeAttendanceService {
  private static final int PRESENT_VALUE = 1; // Random value for Present
  private static final int RANDOM_LIMIT = 2;  // 0 or 1
  
  private final EmployeeRepository employeeRepository;
  private final Random random;

  public EmployeeAttendanceService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
    this.random = new Random();
  }

  public String checkAttendance(int employeeId) {
    Employee employee = employeeRepository.getEmployeeById(employeeId);
    
    if (employee == null) {
      return "Employee not found!";
    }

    int attendanceValue = random.nextInt(RANDOM_LIMIT);
    String status = (attendanceValue == PRESENT_VALUE) ? "PRESENT" : "ABSENT";
    
    employee.setAttendanceStatus(status);
    employeeRepository.updateEmployee(employee);

    return status;
  }

  public void checkAttendanceForAll() {
    employeeRepository.getAllEmployees().forEach(employee -> {
      int attendanceValue = random.nextInt(RANDOM_LIMIT);
      String status = (attendanceValue == PRESENT_VALUE) ? "PRESENT" : "ABSENT";
      employee.setAttendanceStatus(status);
      employeeRepository.updateEmployee(employee);
    });
  }

  public String getAttendanceStatus(int employeeId) {
    Employee employee = employeeRepository.getEmployeeById(employeeId);
    if (employee != null) {
      return employee.getAttendanceStatus();
    }
    return "Employee not found!";
  }
}
