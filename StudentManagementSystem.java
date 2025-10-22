import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Student
class Student {
    int id;
    String name;
    double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

// Main class for managing the student system
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    // Add new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    // View all students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("\n----- Student List -----");
        for (Student s : students) {
            s.display();
        }
    }

    // Update existing student details
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();
                System.out.println("✅ Student updated successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Delete a student record
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("✅ Student deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }
}
