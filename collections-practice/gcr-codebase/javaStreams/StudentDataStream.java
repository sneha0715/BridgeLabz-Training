import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Sneha");
            dos.writeDouble(8.7);
            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data.");
            return;
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Student Data Retrieved:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading student data.");
        }
    }
}
