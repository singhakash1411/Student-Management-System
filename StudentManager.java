import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> studentList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchStudent();
                case 0 -> System.out.println("Exiting system. Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Search Student by ID");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("✅ Student added successfully.");
    }

    private void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    private void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();

        Student student = findById(id);
        if (student == null) {
            System.out.println("❌ Student not found.");
            return;
        }

        System.out.print("Enter new Name: ");
        student.setName(sc.nextLine());
        System.out.print("Enter new Age: ");
        student.setAge(sc.nextInt());
        sc.nextLine(); // Consume newline
        System.out.print("Enter new Course: ");
        student.setCourse(sc.nextLine());

        System.out.println("✅ Student updated successfully.");
    }

    private void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();

        Student student = findById(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("✅ Student deleted successfully.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    private void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();

        Student student = findById(id);
        if (student != null) {
            System.out.println("🔍 Student Found:\n" + student);
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    private Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
