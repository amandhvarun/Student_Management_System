import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    Student s1 = new Student(name, email, course);
                    if (dao.addStudent(s1)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();
                    if (list.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\nID\tName\tEmail\t\tCourse");
                        for (Student s : list) {
                            System.out.println(s.getId() + "\t" + s.getName() + "\t" +
                                    s.getEmail() + "\t" + s.getCourse());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    Student updated = new Student(idToUpdate, newName, newEmail, newCourse);
                    if (dao.updateStudent(updated)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Update failed.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int idToDelete = sc.nextInt();
                    if (dao.deleteStudent(idToDelete)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Delete failed.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
