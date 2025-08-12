import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Search Student\n6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    sms.addStudent(new Student(id, name, email));
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter id to update: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    name = sc.nextLine();
                    System.out.print("Enter new email: ");
                    email = sc.nextLine();
                    sms.updateStudent(id, name, email);
                    break;
                case 4:
                    System.out.print("Enter id to delete: ");
                    id = sc.nextInt();
                    sms.deleteStudent(id);
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    name = sc.nextLine();
                    Student s = sms.searchStudentByName(name);
                    System.out.println(s != null ? s : "Student not found.");
                    break;
                case 6:
                    sc.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
