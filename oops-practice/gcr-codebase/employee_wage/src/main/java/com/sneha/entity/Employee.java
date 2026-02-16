package com.sneha.entity;


public class Employee {
  private int employeeId;
  private String employeeName;
  private double attendancePercentage;
  private String attendanceStatus; 

  public Employee() {
  }

  public Employee(int employeeId, String employeeName) {
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.attendanceStatus = "ABSENT"; 
    this.attendancePercentage = 0.0;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public double getAttendancePercentage() {
    return attendancePercentage;
  }

  public void setAttendancePercentage(double attendancePercentage) {
    this.attendancePercentage = attendancePercentage;
  }

  public String getAttendanceStatus() {
    return attendanceStatus;
  }

  public void setAttendanceStatus(String attendanceStatus) {
    this.attendanceStatus = attendanceStatus;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "employeeId=" + employeeId +
        ", employeeName='" + employeeName + '\'' +
        ", attendanceStatus='" + attendanceStatus + '\'' +
        ", attendancePercentage=" + attendancePercentage +
        '}';
  }
}
