package com.fpi.assignmentfinal.tiennv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

// Student class stores student data: ID, name, marks, and computes ranking.
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

// Manages student data: add/edit/delete, sort by marks, search by marks, ID, or name using Binary Search.
class StudentManager {
    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    // Function to manage student records: add, edit, delete based on action parameter.
    // This combines 3 functionalities into one as required by specification.
    public void manageStudent(String action, String id, String name, Double marks) throws Exception {
        switch (action.toLowerCase()) {
            case "add":
                for (Student s : studentList) {
                    if (s.getId().equals(id)) throw new Exception("Student ID already exists!");
                }
                if (marks < 0 || marks > 10) throw new Exception("Marks must be between 0 and 10!");
                studentList.add(new Student(id, name, marks));
                System.out.println("Student added successfully.");
                break;
            case "edit":
                for (Student s : studentList) {
                    if (s.getId().equals(id)) {
                        if (marks < 0 || marks > 10) throw new Exception("Marks must be between 0 and 10!");
                        s.setName(name);
                        s.setMarks(marks);
                        System.out.println("Student updated successfully.");
                        return;
                    }
                }
                throw new Exception("Student not found!");
            case "delete":
                Iterator<Student> iterator = studentList.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getId().equals(id)) {
                        iterator.remove();
                        System.out.println("Student deleted successfully.");
                        return;
                    }
                }
                throw new Exception("Student not found!");
            default:
                throw new Exception("Invalid action!");
        }
    }

    // Implements Quick Sort algorithm to sort students by marks in descending order.
    private void quickSortByMarks(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pi = partitionByMarks(list, low, high);
            quickSortByMarks(list, low, pi - 1);
            quickSortByMarks(list, pi + 1, high);
        }
    }

    private int partitionByMarks(ArrayList<Student> list, int low, int high) {
        double pivot = list.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getMarks() > pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    // Returns new sorted list using QuickSort
    public ArrayList<Student> sortStudentsByMarksUsingQuickSort() {
        ArrayList<Student> sortedList = new ArrayList<>(studentList);
        quickSortByMarks(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }

    // Sorts list by ID using Quick Sort and returns sorted list
    private void quickSortById(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pi = partitionById(list, low, high);
            quickSortById(list, low, pi - 1);
            quickSortById(list, pi + 1, high);
        }
    }

    private int partitionById(ArrayList<Student> list, int low, int high) {
        String pivot = list.get(high).getId();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getId().compareTo(pivot) < 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    // Sorts list by name using Quick Sort and returns sorted list
    private void quickSortByName(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pi = partitionByName(list, low, high);
            quickSortByName(list, low, pi - 1);
            quickSortByName(list, pi + 1, high);
        }
    }

    private int partitionByName(ArrayList<Student> list, int low, int high) {
        String pivot = list.get(high).getName();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getName().compareToIgnoreCase(pivot) < 0) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    // Binary Search on sorted list by marks
    public Student searchStudentByMarksUsingBinarySearch(double targetMarks) {
        ArrayList<Student> students = sortStudentsByMarksUsingQuickSort();
        int left = 0, right = students.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double midMarks = students.get(mid).getMarks();
            if (midMarks == targetMarks) return students.get(mid);
            else if (midMarks < targetMarks) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    // Binary Search by ID using Quick Sort first then binary search manually
    public Student searchStudentByIdUsingBinarySearch(String targetId) {
        ArrayList<Student> sortedList = new ArrayList<>(studentList);
        quickSortById(sortedList, 0, sortedList.size() - 1);
        int left = 0, right = sortedList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sortedList.get(mid).getId().compareTo(targetId);
            if (cmp == 0) return sortedList.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Binary Search by Name using Quick Sort first then binary search manually
    public Student searchStudentByNameUsingBinarySearch(String targetName) {
        ArrayList<Student> sortedList = new ArrayList<>(studentList);
        quickSortByName(sortedList, 0, sortedList.size() - 1);
        int left = 0, right = sortedList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sortedList.get(mid).getName().compareToIgnoreCase(targetName);
            if (cmp == 0) return sortedList.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Displays all student records
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks (QuickSort)");
            System.out.println("5. Search Student by Marks (Binary Search)");
            System.out.println("6. Search Student by ID (Binary Search)");
            System.out.println("7. Search Student by Name (Binary Search)");
            System.out.println("8. Display All Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                String id, name;
                double marks;
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        id = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        marks = scanner.nextDouble();
                        manager.manageStudent("add", id, name, marks);
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        id = scanner.nextLine();
                        System.out.print("Enter New Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter New Marks: ");
                        marks = scanner.nextDouble();
                        manager.manageStudent("edit", id, name, marks);
                        break;
                    case 3:
                        System.out.print("Enter ID to delete: ");
                        id = scanner.nextLine();
                        manager.manageStudent("delete", id, null, null);
                        break;
                    case 4:
                        ArrayList<Student> sorted = manager.sortStudentsByMarksUsingQuickSort();
                        for (Student s : sorted) System.out.println(s);
                        break;
                    case 5:
                        System.out.print("Enter Marks: ");
                        marks = scanner.nextDouble();
                        Student sByMarks = manager.searchStudentByMarksUsingBinarySearch(marks);
                        System.out.println(sByMarks != null ? sByMarks : "No student with that mark.");
                        break;
                    case 6:
                        System.out.print("Enter ID: ");
                        id = scanner.nextLine();
                        Student sById = manager.searchStudentByIdUsingBinarySearch(id);
                        System.out.println(sById != null ? sById : "No student with that ID.");
                        break;
                    case 7:
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        Student sByName = manager.searchStudentByNameUsingBinarySearch(name);
                        System.out.println(sByName != null ? sByName : "No student with that name.");
                        break;
                    case 8:
                        manager.displayAllStudents();
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
