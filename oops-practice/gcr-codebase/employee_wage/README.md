# Employee Wage System - UC-1: Check Attendance

## Overview
This implementation covers **UC-1: Check Employee Attendance (Present/Absent)** using a **Four-Level Architecture** with random generation for attendance marking.

## Architecture Layers

### 1. **Entity Layer** (`entity/Employee.java`)
- Represents the Employee domain object
- Contains attendance-related properties:
  - `employeeId`: Unique identifier
  - `employeeName`: Employee name
  - `attendanceStatus`: PRESENT or ABSENT
  - `attendancePercentage`: Attendance tracking (for future use)

### 2. **Repository Layer** (`repository/EmployeeRepository.java`)
- Manages data persistence and retrieval
- **Features:**
  - `getEmployeeById()`: Fetch employee by ID
  - `getAllEmployees()`: Fetch all employees
  - `addEmployee()`: Add new employee
  - `updateEmployee()`: Update employee details
  - `deleteEmployee()`: Delete employee
  - Pre-initialized with 5 default employees (IDs: 101-105)

### 3. **Service Layer** (`services/EmployeeAttendanceService.java`)
- Implements business logic
- **Features:**
  - Uses `Random` to generate attendance (0 = ABSENT, 1 = PRESENT)
  - `checkAttendance()`: Check attendance for single employee
  - `checkAttendanceForAll()`: Mark attendance for all employees
  - `getAttendanceStatus()`: Retrieve attendance status

### 4. **Controller Layer** (`controller/EmployeeAttendanceController.java`)
- Handles user interaction
- **Features:**
  - Menu-driven interface
  - Input validation
  - Error handling with logging
  - 5 main operations:
    1. Check Attendance for Specific Employee
    2. Check Attendance for All Employees
    3. View All Employees
    4. View Attendance Status
    5. Exit

### 5. **Main Application** (`App.java`)
- Entry point for the application
- Initializes controller and runs the attendance system

## Use Case 1: Check Employee Attendance

### Functionality
- **Random Attendance Generation**: Uses `Math.random()` to determine if employee is PRESENT (1) or ABSENT (0)
- **Single Employee Attendance**: Check attendance for a specific employee ID
- **Bulk Attendance**: Mark attendance for all employees at once
- **View Status**: Display current attendance status

### Workflow
```
User Input → Controller → Service (Random Generation) → Repository (Update) → Display Result
```

## Default Employees
```
ID: 101 | Name: Sneha
ID: 102 | Name: Amit
ID: 103 | Name: Neha
ID: 104 | Name: Ravi
ID: 105 | Name: Priya
```

## How to Run

1. **Compile the project:**
   ```bash
   mvn compile
   ```

2. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.sneha.App"
   ```

3. **Menu Options:**
   - Enter `1` to check attendance for a specific employee
   - Enter `2` to mark attendance for all employees
   - Enter `3` to view all employees
   - Enter `4` to view individual attendance status
   - Enter `5` to exit

## Sample Output
```
=============== Employee Wage System - UC1: Check Attendance ===============
1. Check Attendance for Specific Employee
2. Check Attendance for All Employees
3. View All Employees
4. View Attendance Status
5. Exit
================================================================================
Enter your choice: 2

Checking attendance for all employees...

✅ Attendance marked for all employees:
───────────────────────────────────────────────────────────────────────────────
ID: 101 | Name: Sneha          | Status: PRESENT
ID: 102 | Name: Amit           | Status: ABSENT
ID: 103 | Name: Neha           | Status: PRESENT
ID: 104 | Name: Ravi           | Status: ABSENT
ID: 105 | Name: Priya          | Status: PRESENT
───────────────────────────────────────────────────────────────────────────────
```

## Design Principles Used
✅ **Separation of Concerns** - Each layer has distinct responsibility
✅ **Single Responsibility** - Each class has one purpose
✅ **Loose Coupling** - Layers interact through defined interfaces
✅ **High Cohesion** - Related functionality grouped together
✅ **DRY Principle** - No code duplication
✅ **Proper Exception Handling** - Graceful error management
✅ **Logging** - For monitoring and debugging

## Future Enhancements
- Add wage calculation based on attendance
- Implement database persistence (JDBC)
- Add attendance history tracking
- Generate attendance reports
- Add validation for attendance data
- Implement authentication/authorization
