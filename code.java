import java.util.HashMap;
import java.util.Scanner;

public class StudentManagementSystem {
    private HashMap<String, Student> studentMap;

    public StudentManagementSystem() {
        studentMap = new HashMap<>();
    }

    public void addStudent(String id, String name, int age) {
        Student student = new Student(id, name, age);
        studentMap.put(id, student);
        System.out.println("Student added: " + student);
    }

    public void getStudent(String id) {
        Student student = studentMap.get(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (Student student : studentMap.values()) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    sms.addStudent(id, name, age);
                    break;
                case 2:
                    System.out.print("Enter Student ID to retrieve: ");
                    String searchId = scanner.nextLine();
                    sms.getStudent(searchId);
                    break;
                case 3:
                    sms.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
