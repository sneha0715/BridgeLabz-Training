public class CircleConstructor {
    private double radius;

    // Default constructor
    public CircleConstructor() {
        this(1.0);
    }

    // Parameterized constructor
    public CircleConstructor(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void showDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public static void main(String[] args) {
        // Using default constructor
        CircleConstructor defaultCircle = new CircleConstructor();
        defaultCircle.showDetails();

        System.out.println();

        // Using parameterized constructor
        CircleConstructor customCircle = new CircleConstructor(5.0);
        customCircle.showDetails();
    }
}
