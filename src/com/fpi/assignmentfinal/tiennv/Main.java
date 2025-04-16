package com.fpi.assignmentfinal.tiennv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

// Lớp Student để lưu trữ thông tin sinh viên
class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    // Xác định xếp hạng dựa trên điểm
    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks <= 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + getRanking();
    }
}

// Lớp StudentManager để quản lý danh sách sinh viên
class StudentManager {
    private ArrayList<Student> students;
    private HashMap<String, Student> studentMap;

    public StudentManager() {
        students = new ArrayList<>();
        studentMap = new HashMap<>();
    }

    // Thêm sinh viên
    public void addStudent(String id, String name, double marks) throws Exception {
        if (studentMap.containsKey(id)) {
            throw new Exception("Student ID " + id + " already exists!");
        }
        if (marks < 0 || marks > 10) {
            throw new Exception("Marks must be between 0 and 10!");
        }
        Student student = new Student(id, name, marks);
        students.add(student);
        studentMap.put(id, student);
        System.out.println("Student added successfully: " + student);
    }

    // Sửa thông tin sinh viên
    public void editStudent(String id, String newName, double newMarks) throws Exception {
        Student student = studentMap.get(id);
        if (student == null) {
            throw new Exception("Student ID " + id + " not found!");
        }
        if (newMarks < 0 || newMarks > 10) {
            throw new Exception("Marks must be between 0 and 10!");
        }
        student.setName(newName);
        student.setMarks(newMarks);
        System.out.println("Student updated successfully: " + student);
    }
// Tìm kiếm sinh viên theo tên (không phân biệt hoa thường)
public ArrayList<Student> findStudentsByName(String name) {
    ArrayList<Student> result = new ArrayList<>();
    for (Student student : students) {
        if (student.getName().toLowerCase().contains(name.toLowerCase())) {
            result.add(student);
        }
    }
    return result;
}
    // Xóa sinh viên
    public void deleteStudent(String id) throws Exception {
        Student student = studentMap.remove(id);
        if (student == null) {
            throw new Exception("Student ID " + id + " not found!");
        }
        students.remove(student);
        System.out.println("Student deleted successfully: " + student);
    }

    // Sắp xếp danh sách sinh viên theo điểm (giảm dần)
    public void sortStudentsByMarks() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks:");
        displayStudents();
    }

    // Tìm kiếm nhị phân theo điểm (giả sử danh sách đã sắp xếp)
    public Student binarySearchByMarks(double targetMarks) {
        int left = 0;
        int right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double midMarks = students.get(mid).getMarks();
            if (midMarks == targetMarks) {
                return students.get(mid);
            } else if (midMarks > targetMarks) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Không tìm thấy
    }

    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Tìm kiếm sinh viên theo ID bằng HashMap
    public Student findStudentById(String id) {
        return studentMap.get(id);
    }
}

// Chương trình chính
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Search Student by Marks");
            System.out.println("7. Search Student by Name");
            System.out.println("8. Display Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

           try {
    switch (choice) {
        case 1:
            System.out.print("Enter ID: ");
            String id = scanner.nextLine().trim();
            if (id.isEmpty()) throw new Exception("ID cannot be empty.");
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new Exception("Name cannot be empty.");

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            manager.addStudent(id, name, marks);
            break;
        case 2:
            System.out.print("Enter ID to edit: ");
            id = scanner.nextLine().trim();
            System.out.print("Enter new Name: ");
            name = scanner.nextLine().trim();
            System.out.print("Enter new Marks: ");
            marks = scanner.nextDouble();
            manager.editStudent(id, name, marks);
            break;
        case 3:
            System.out.print("Enter ID to delete: ");
            id = scanner.nextLine().trim();
            manager.deleteStudent(id);
            break;
        case 4:
            manager.sortStudentsByMarks();
            break;
        case 5:
            System.out.print("Enter ID to search: ");
            id = scanner.nextLine().trim();
            Student student = manager.findStudentById(id);
            System.out.println(student != null ? student : "Student not found!");
            break;
        case 6:
            System.out.print("Enter Marks to search: ");
            marks = scanner.nextDouble();
            student = manager.binarySearchByMarks(marks);
            System.out.println(student != null ? student : "No student with marks " + marks);
            break;
        case 7:
    System.out.print("Enter name to search: ");
    String searchName = scanner.nextLine().trim();
    ArrayList<Student> foundStudents = manager.findStudentsByName(searchName);
    if (foundStudents.isEmpty()) {
        System.out.println("No students found with name: " + searchName);
    } else {
        System.out.println("Students found:");
        for (Student s : foundStudents) {
            System.out.println(s);
        }
    }
    break;
case 8:
    manager.displayStudents();
    break;
case 9:
    System.out.println("Exiting...");
    scanner.close();
    return;

        default:
            System.out.println("Invalid choice! Please try again.");
    }
} catch (InputMismatchException e) {
    System.out.println("Invalid input type! Please enter the correct data format.");
    scanner.nextLine(); // clear buffer
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

        }
    }
}