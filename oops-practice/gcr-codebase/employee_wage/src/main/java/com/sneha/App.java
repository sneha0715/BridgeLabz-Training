package com.sneha;

import com.sneha.controller.EmployeeAttendanceController;

public class App {
  public static void main(String[] args) {
    EmployeeAttendanceController controller = new EmployeeAttendanceController();
    controller.run();
    controller.closeScanner();
  }
}

