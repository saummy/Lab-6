import java.util.Scanner;

class Student {
    String regNo;
    String name;
    String email;
    String phone;
    String stdClass;
    String department;

    public Student(String regNo, String name, String email, String phone, String stdClass, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.stdClass = stdClass;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Reg. No.: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + stdClass);
        System.out.println("Department: " + department);
    }
}

public class lab5 {
    static Scanner scanner = new Scanner(System.in);
    static Student[] students = new Student[100];
    static int numStudents = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Display all students");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    displayAllStudents();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void addStudent() {
        if (numStudents >= 100) {
            System.out.println("Cannot add more students. Maximum limit reached.");
            return;
        }

        System.out.print("Enter Reg. No.: ");
        String regNo = scanner.next();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Email: ");
        String email = scanner.next();
        System.out.print("Enter Phone: ");
        String phone = scanner.next();
        System.out.print("Enter Class: ");
        String stdClass = scanner.next();
        System.out.print("Enter Department: ");
        String department = scanner.next();

        Student student = new Student(regNo, name, email, phone, stdClass, department);
        students[numStudents++] = student;

        System.out.println("Student added successfully!");
    }

    public static void searchStudent() {
        System.out.print("Enter Reg. No. of student to search: ");
        String regNo = scanner.next();

        for (int i = 0; i < numStudents; i++) {
            if (students[i].regNo.equals(regNo)) {
                students[i].printDetails();
                return;
            }
        }

        System.out.println("No student found with Reg. No.: " + regNo);
    }

    public static void displayAllStudents() {
        for (int i = 0; i < numStudents; i++) {
            students[i].printDetails();
            System.out.println();
        }
    }
}