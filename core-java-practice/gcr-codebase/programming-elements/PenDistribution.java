public class PenDistribution {
    public static void main(String[] args) {
        int totalPen = 14;
        int students = 3;
        int penPerStudent = totalPen / students;
        int remainingPen = totalPen % students;

        System.out.println("The Pen Per Student is " + penPerStudent + " and the remaining pen not distributed is " + remainingPen);
    }
}
