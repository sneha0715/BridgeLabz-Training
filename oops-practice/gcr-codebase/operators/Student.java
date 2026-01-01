public class Student {

    static String universityName = "Global University";
    static int studentCount = 0;
    String name;
    String grade;
    final int rollNumber;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        studentCount++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + studentCount);
        System.out.println("University Name: " + universityName);
    }

    public static void displayStudent(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println();
            System.out.println("Grade: " + s.grade);
        }
    }

    public static void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.grade = newGrade;
            System.out.println("Grade updated to: " + s.grade);
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student(
                "Hemashree",
                101,
                "A"
        );

        Student s2 = new Student(
                "Sharmila",
                102,
                "B"
        );

        displayTotalStudents();

        displayStudent(s1);
        System.out.println("University Name: " + universityName);

        displayStudent(s2);
        System.out.println("University Name: " + universityName);

        updateGrade(s2, "A");

        displayStudent(s2);
        System.out.println("University Name: " + universityName);
    }
}
