class Student {
    String name;
    int rollNumber;
    int marks;
    char grade;

    void calculateGrade() {
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println();
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rohan";
        s1.rollNumber = 101;
        s1.marks = 85;
        s1.calculateGrade();
        s1.displayDetails();
    }
}
