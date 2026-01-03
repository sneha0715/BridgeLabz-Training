public class SchoolSystem {
    public static void main(String[] args) {
        Person[] people = {
            new Teacher("Sneha", 28, "Mathematics"),
            new Student("Rahul", 16, "10th Grade"),
            new Staff("Anita", 35, "Administration")
        };

        for (Person p : people) {
            p.displayDetails();
            p.displayRole();

        }
    }
}
