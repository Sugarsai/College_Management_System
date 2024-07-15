package AdminClasses;

import Gen.Person;
import UserClasses.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Admin extends Person {
    private static Admin instance;
    private ArrayList<Student> students;
    private ArrayList<Doctor> doctors;

    private Admin() {
        super("admin@gmail.com", "admin123");
        this.students = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }
    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    public boolean login(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }
    @Override
    public String getName() {
        return "Admin";
    }
    private String getEmail() {
        return this.email;
    }
    private String getPassword() {
        return this.password;
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
                addDoctor(name, email, password);
                break;
            case 2:
                addStudent(name, email, password);
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

    private void addDoctor(String name, String email, String password) {
        Doctor doc = new Doctor(name, email, password);
        doctors.add(doc);
        System.out.println("Doctor added: " + doc.getName() + " (ID: " + doc.getID() + ")\n");
    }
    private void addStudent(String name, String email, String password) {
        Student std = new Student(name, email, password);
        students.add(std);
        System.out.println("Student added: " + std.getName() + " (ID: " + std.getID() + ")\n");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.\n");
        } else {
            for (Student std : students) {
                System.out.println("ID: " + std.getID() + ", Name: " + std.getName() + ", Email: " + std.getEmail());
            }
        }
    }
    public void listDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.\n");
        } else {
            for (Doctor doc : doctors) {
                System.out.println("ID: " + doc.getID() + ", Name: " + doc.getName() + ", Email: " + doc.getEmail());
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

}
