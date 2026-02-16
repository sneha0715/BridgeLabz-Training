# Employee Wage System - UC-1 Implementation Summary

## ✅ Project Structure (Four-Level Architecture)

```
com/sneha/
├── App.java (Main Entry Point)
├── entity/
│   └── Employee.java (Domain Model)
├── repository/
│   └── EmployeeRepository.java (Data Access Layer)
├── services/
│   └── EmployeeAttendanceService.java (Business Logic Layer)
├── controller/
│   └── EmployeeAttendanceController.java (Presentation Layer)
└── test/
    └── AttendanceTest.java (Unit Test)
```

## 📋 Use Case 1: Check Employee Attendance

### Objective
Track employee attendance using **RANDOM** generation to mark employees as **PRESENT** or **ABSENT**.

### Implementation Details

#### 1. **Entity Layer** - `Employee.java`
```java
Properties:
- employeeId (int): Unique identifier
- employeeName (String): Employee name
- attendanceStatus (String): PRESENT/ABSENT
- attendancePercentage (double): For future use

Methods:
- Getters/Setters
- toString() for display
```

#### 2. **Repository Layer** - `EmployeeRepository.java`
```java
Features:
✓ In-memory database (ArrayList)
✓ Pre-initialized with 5 employees (IDs: 101-105)
✓ CRUD operations:
  - getEmployeeById(int)
  - getAllEmployees()
  - addEmployee(Employee)
  - updateEmployee(Employee)
  - deleteEmployee(int)
```

#### 3. **Service Layer** - `EmployeeAttendanceService.java`
```java
Business Logic:
✓ Random attendance generation (0 or 1)
✓ 0 = ABSENT, 1 = PRESENT
✓ checkAttendance(int employeeId) - Single employee
✓ checkAttendanceForAll() - Bulk marking
✓ getAttendanceStatus(int employeeId) - Retrieve status
```

#### 4. **Controller Layer** - `EmployeeAttendanceController.java`
```java
User Interface:
✓ Menu-driven application
✓ 5 Operations:
  1. Check Attendance for Specific Employee
  2. Check Attendance for All Employees
  3. View All Employees
  4. View Attendance Status
  5. Exit
✓ Input validation
✓ Error handling with logging
```

#### 5. **Main Application** - `App.java`
```java
- Entry point
- Initializes controller
- Runs the application loop
- Closes resources
```

## 🎯 Key Features

### Random Attendance Generation
```
Random random = new Random();
int attendanceValue = random.nextInt(2); // 0 or 1
```

### Attendance Marking
- **PRESENT** (1): Employee is present
- **ABSENT** (0): Employee is absent

### Default Employees
```
ID: 101 | Sneha
ID: 102 | Amit
ID: 103 | Neha
ID: 104 | Ravi
ID: 105 | Priya
```

## 🚀 How to Use

### Method 1: Run Interactive Menu
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.sneha.App"
```

### Method 2: Run Test Class
```bash
mvn exec:java -Dexec.mainClass="com.sneha.test.AttendanceTest"
```

## 📊 Sample Menu Output

```
=============== Employee Wage System - UC1: Check Attendance ===============
1. Check Attendance for Specific Employee
2. Check Attendance for All Employees
3. View All Employees
4. View Attendance Status
5. Exit
================================================================================
Enter your choice: 1

Enter Employee ID: 101
✅ Employee ID: 101 | Attendance: PRESENT
```

## 🔄 Workflow Diagram

```
┌─────────┐
│ User    │
│ Input   │
└────┬────┘
     │
     ▼
┌─────────────────────────────────┐
│ EmployeeAttendanceController    │
│ (Presentation Layer)            │
└────┬────────────────────────────┘
     │
     ▼
┌─────────────────────────────────┐
│ EmployeeAttendanceService       │
│ (Business Logic)                │
│ - Random Generation             │
│ - Validation                    │
└────┬────────────────────────────┘
     │
     ▼
┌─────────────────────────────────┐
│ EmployeeRepository              │
│ (Data Access)                   │
└────┬────────────────────────────┘
     │
     ▼
┌─────────────────────────────────┐
│ Employee Entity                 │
│ (Domain Model)                  │
└─────────────────────────────────┘
```

## ✨ Design Principles Applied

✅ **Separation of Concerns** - Each layer has specific responsibility
✅ **Single Responsibility Principle** - Each class has one reason to change
✅ **Dependency Injection** - Services receive dependencies
✅ **Loose Coupling** - Layers communicate through interfaces
✅ **High Cohesion** - Related functionality grouped together
✅ **DRY Principle** - No code duplication
✅ **Proper Exception Handling** - Graceful error management
✅ **Logging** - For monitoring and debugging

## 📈 Scalability for Future Enhancements

This architecture supports adding:
- **UC-2**: Calculate Employee Wage
- **UC-3**: Add Attendance History
- **UC-4**: Generate Reports
- Database persistence (JDBC)
- REST API endpoints
- Authentication/Authorization
- Attendance analytics

## 🧪 Testing

The `AttendanceTest.java` class demonstrates:
1. Single employee attendance checking (3 iterations)
2. Bulk attendance marking for all employees
3. Retrieving specific employee status
4. Display of all employees with updated status

## ✅ Verification

All files compiled successfully with no errors:
- ✓ Employee.java
- ✓ EmployeeRepository.java
- ✓ EmployeeAttendanceService.java
- ✓ EmployeeAttendanceController.java
- ✓ App.java
- ✓ AttendanceTest.java

## 📝 Notes

- The application uses Java's built-in `Random` class for attendance generation
- Data is stored in-memory (ArrayList) - suitable for demonstration
- For production, replace with database persistence layer
- All user inputs are validated before processing
- Comprehensive logging for debugging and monitoring
