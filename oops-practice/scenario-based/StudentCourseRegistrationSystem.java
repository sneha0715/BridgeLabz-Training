import java.util.*;

class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

interface RegistrationService {
    void enrollCourse(String course) throws CourseLimitExceededException;
    void dropCourse(String course);
    void showGrades();
}

class Student extends Person implements RegistrationService {

    private int studentId;
    private List<String> enrolledCourses;
    private Map<String, String> gradeBook;
    private final int MAX_COURSES = 3;

    public Student(int studentId, String name, int age) {
        super(name, age);
        this.studentId = studentId;
        enrolledCourses = new ArrayList<>();
        gradeBook = new HashMap<>();
    }

    public void enrollCourse(String course) throws CourseLimitExceededException {
        if (enrolledCourses.size() >= MAX_COURSES) {
            throw new CourseLimitExceededException(
                    "Cannot enroll in more than " + MAX_COURSES + " courses"
            );
        }
        enrolledCourses.add(course);
        gradeBook.put(course, "Not Assigned");
        System.out.println("Enrolled in " + course);
    }

    public void dropCourse(String course) {
        if (enrolledCourses.remove(course)) {
            gradeBook.remove(course);
            System.out.println("Dropped " + course);
        } else {
            System.out.println("Course not found");
        }
    }

    public void assignGrade(String course, String grade) {
        if (gradeBook.containsKey(course)) {
            gradeBook.put(course, grade);
        }
    }

    public void showGrades() {
        System.out.println("Grades of " + getName());
        for (String course : gradeBook.keySet()) {
            System.out.println(course + " : " + gradeBook.get(course));
        }
    }

    public void showStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Courses: " + enrolledCourses);
    }
}

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {

        Student student = new Student(101, "Sneha", 21);

        try {
            student.enrollCourse("Java");
            student.enrollCourse("DBMS");
            student.enrollCourse("Web");
            student.enrollCourse("AI");
        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        student.assignGrade("Java", "A");
        student.assignGrade("DBMS", "B+");
        student.assignGrade("Web", "A");

        student.showStudentInfo();
        student.showGrades();

        student.dropCourse("DBMS");
        student.showStudentInfo();
    }
}
