public class PersonConstructor {
    private String name;
    private int age;

    // Parameterized constructor
    public PersonConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public PersonConstructor(PersonConstructor other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        PersonConstructor person1 = new PersonConstructor("Alice", 25);
        person1.showDetails();

        System.out.println();

        PersonConstructor person2 = new PersonConstructor(person1);
        person2.showDetails();
    }
}
