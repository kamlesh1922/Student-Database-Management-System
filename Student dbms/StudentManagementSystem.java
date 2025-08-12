import java.util.*;
import java.io.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void updateStudent(int id, String name, String email) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setEmail(email);
                saveToFile();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            saveToFile();
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Save list to file
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load list from file
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                students = (ArrayList<Student>) in.readObject();
            } catch (Exception e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        }
    }
}
