package AdminClasses;

import UserClasses.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Admin {
    private String email;
    private String password;
    private ArrayList<Student> students;
    private ArrayList<Doctor> doctors;

    public Admin() {
        this.email = "admin@gmail.com";
        this.password = "admin123";
        this.students = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }

    public void addUser() {
        Scanner scanner = new Scanner(System.in);

        usersMenu();

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter User name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        switch(choice) {
            case 1:
                Doctor doc = new Doctor(name, email, password);
                doctors.add(doc);
                System.out.println("Doctor added: " + doc.getName() + " (ID: " + doc.getID() + ")\n");
                break;
            case 2:
                Student std = new Student(name, email, password);
                students.add(std);
                System.out.println("Student added: " + std.getName() + " (ID: " + std.getID() + ")\n");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

    }
    private void usersMenu() {
        System.out.println("Select the type of user to add: ");
        System.out.println("1. Doctor");
        System.out.println("2. Student");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student std : students) {
                System.out.println("ID: " + std.getID() + ", Name: " + std.getName() + ", Email: " + std.getEmail());
            }
        }
    }
    public void listDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doc : doctors) {
                System.out.println("ID: " + doc.getID() + ", Name: " + doc.getName() + ", Email: " + doc.getEmail());
            }
        }
    }

}
