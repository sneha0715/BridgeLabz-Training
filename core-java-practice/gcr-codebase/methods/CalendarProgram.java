import java.util.Scanner;

public class CalendarProgram {

    public static String getMonthName(int m) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[m];
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getDaysInMonth(int m, int y) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && isLeapYear(y)) return 29;
        return days[m];
    }

    public static int getFirstDayOfMonth(int m, int y) {
        int d = 1; 
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12) and year (e.g., 07 2005): ");
        int month = sc.nextInt();
        int year = sc.nextInt();

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        System.out.println("\n " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            if (((day + firstDay) % 7 == 0) || (day == daysInMonth)) {
                System.out.println();
            }
        }
        
        sc.close();
    }
}
