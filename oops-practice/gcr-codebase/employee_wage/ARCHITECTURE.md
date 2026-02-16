# Employee Wage System - Four-Level Architecture Overview

## 🏗️ Architecture Layers

### Layer 1: Presentation/Controller Layer
**File:** `EmployeeAttendanceController.java`

**Responsibility:** User Interface and Input Handling
```
┌─────────────────────────────────────────────┐
│  EmployeeAttendanceController               │
│  ┌───────────────────────────────────────┐  │
│  │ - displayMenu()                       │  │
│  │ - checkAttendanceForEmployee()        │  │
│  │ - checkAttendanceForAll()             │  │
│  │ - viewAllEmployees()                  │  │
│  │ - viewAttendanceStatus()              │  │
│  │ - run() [Main Loop]                   │  │
│  │ - closeScanner()                      │  │
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
```

**Features:**
- Menu-driven interface
- Input validation
- Error handling
- User-friendly output formatting

---

### Layer 2: Service Layer (Business Logic)
**File:** `EmployeeAttendanceService.java`

**Responsibility:** Business Logic Implementation
```
┌─────────────────────────────────────────────┐
│  EmployeeAttendanceService                  │
│  ┌───────────────────────────────────────┐  │
│  │ - PRESENT_VALUE = 1                   │  │
│  │ - RANDOM_LIMIT = 2                    │  │
│  │ - checkAttendance(int)                │  │
│  │ - checkAttendanceForAll()             │  │
│  │ - getAttendanceStatus(int)            │  │
│  │ - Random Generation Logic             │  │
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
```

**Features:**
- Random attendance generation (0 = ABSENT, 1 = PRESENT)
- Business logic separated from UI
- Reusable service methods

---

### Layer 3: Repository Layer (Data Access)
**File:** `EmployeeRepository.java`

**Responsibility:** Data Persistence and Retrieval
```
┌─────────────────────────────────────────────┐
│  EmployeeRepository                         │
│  ┌───────────────────────────────────────┐  │
│  │ - employees: List<Employee>           │  │
│  │ - getEmployeeById(int)                │  │
│  │ - getAllEmployees()                   │  │
│  │ - addEmployee(Employee)               │  │
│  │ - updateEmployee(Employee)            │  │
│  │ - deleteEmployee(int)                 │  │
│  │ - initializeEmployees()               │  │
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
```

**Features:**
- In-memory data storage (ArrayList)
- CRUD operations
- Pre-initialized with 5 employees
- Can be extended to support database

---

### Layer 4: Entity Layer (Domain Model)
**File:** `Employee.java`

**Responsibility:** Data Representation
```
┌─────────────────────────────────────────────┐
│  Employee (Entity)                          │
│  ┌───────────────────────────────────────┐  │
│  │ - employeeId: int                     │  │
│  │ - employeeName: String                │  │
│  │ - attendanceStatus: String            │  │
│  │ - attendancePercentage: double        │  │
│  │ - Getters/Setters                     │  │
│  │ - toString()                          │  │
│  └───────────────────────────────────────┘  │
└─────────────────────────────────────────────┘
```

**Features:**
- Pure data class
- No business logic
- Serializable if needed

---

## 🔗 Layer Interactions

```
┌──────────────────────────────────────────────────────────────────┐
│                         App.java (Entry)                         │
└─────────────────────────────┬──────────────────────────────────┘
                              │
                              ▼
┌──────────────────────────────────────────────────────────────────┐
│            EmployeeAttendanceController (Layer 1)                │
│  - Handles all user interactions                                 │
│  - Shows menu and processes choices                              │
│  - Validates inputs                                              │
└─────────────────────────────┬──────────────────────────────────┘
                              │
                              ▼ calls
┌──────────────────────────────────────────────────────────────────┐
│            EmployeeAttendanceService (Layer 2)                   │
│  - Implements business logic                                     │
│  - Generates random attendance (0 or 1)                          │
│  - Updates employee status                                       │
└─────────────────────────────┬──────────────────────────────────┘
                              │
                              ▼ uses
┌──────────────────────────────────────────────────────────────────┐
│              EmployeeRepository (Layer 3)                        │
│  - Manages employee data (CRUD)                                  │
│  - Stores/retrieves from ArrayList                               │
│  - Returns Employee objects                                      │
└─────────────────────────────┬──────────────────────────────────┘
                              │
                              ▼ contains
┌──────────────────────────────────────────────────────────────────┐
│                    Employee (Layer 4)                            │
│  - Data class                                                    │
│  - Pure model with getters/setters                               │
│  - No business logic                                             │
└──────────────────────────────────────────────────────────────────┘
```

---

## 📊 Data Flow Example: Check Single Employee Attendance

```
User Input (Employee ID: 101)
         │
         ▼
Controller.checkAttendanceForEmployee()
         │
         ├─► Validates input
         │
         ▼
Service.checkAttendance(101)
         │
         ├─► Random random = new Random()
         ├─► int value = random.nextInt(2) → 0 or 1
         ├─► String status = (value == 1) ? "PRESENT" : "ABSENT"
         │
         ▼
Repository.getEmployeeById(101)
         │
         ├─► Finds Employee with ID 101
         │
         ▼
Repository.updateEmployee(employee)
         │
         ├─► Updates attendance status
         │
         ▼
Display Result to User
         │
         └─► "✅ Employee ID: 101 | Attendance: PRESENT"
```

---

## 💾 Database Schema (Future Enhancement)

```sql
CREATE TABLE employees (
  employee_id INT PRIMARY KEY,
  employee_name VARCHAR(100) NOT NULL,
  attendance_status VARCHAR(20),
  attendance_percentage DECIMAL(5,2),
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO employees VALUES
(101, 'Sneha', 'ABSENT', 0.0, NOW()),
(102, 'Amit', 'ABSENT', 0.0, NOW()),
(103, 'Neha', 'ABSENT', 0.0, NOW()),
(104, 'Ravi', 'ABSENT', 0.0, NOW()),
(105, 'Priya', 'ABSENT', 0.0, NOW());
```

---

## 🎯 Benefits of Four-Layer Architecture

| Benefit | Description |
|---------|-------------|
| **Separation of Concerns** | Each layer has distinct responsibility |
| **Maintainability** | Easy to locate and fix issues |
| **Testability** | Each layer can be tested independently |
| **Reusability** | Service layer can be used by multiple controllers |
| **Scalability** | Easy to add new features without affecting existing code |
| **Flexibility** | Easy to change data source (ArrayList → Database) |
| **Readability** | Code is organized and easy to understand |

---

## 🔄 Dependency Direction (Acyclic)

```
Layer 1 (Controller)
    │
    ▼ depends on
Layer 2 (Service)
    │
    ▼ depends on
Layer 3 (Repository)
    │
    ▼ depends on
Layer 4 (Entity)
```

**✅ No circular dependencies**
**✅ Clear flow of control**
**✅ Easy to test in isolation**

---

## 🚀 How to Extend for UC-2 (Wage Calculation)

Simply add new methods to the Service layer:
```java
public class EmployeeWageService {
    public double calculateDailyWage(int employeeId) { ... }
    public double calculateMonthlyWage(int employeeId) { ... }
    public double calculateWageWithAttendance(int employeeId) { ... }
}
```

Add new controller methods:
```java
public class EmployeeWageController {
    public void calculateAndDisplayWage(int employeeId) { ... }
    public void displayMonthlyReport() { ... }
}
```

**No changes needed to Repository or Entity layers!**

---

## 📌 Key Takeaways

✅ Four-layer architecture provides clean separation
✅ Each layer has single responsibility
✅ Easy to test and maintain
✅ Scalable for future requirements
✅ Follows SOLID principles
✅ Demonstrates OOP best practices
