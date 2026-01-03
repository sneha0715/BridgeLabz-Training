public class CourseSystem {
    public static void main(String[] args) {

        CourseEducation course = new PaidOnlineCourse(
                "Java Full Stack",
                120,
                "Udemy",
                true,
                10000,
                20
        );

        course.displayCourseDetails();
    }
}
