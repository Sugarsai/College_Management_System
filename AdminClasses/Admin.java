package AdminClasses;

import Gen.Person;
import UserClasses.*;
import Menus.MenuPrinter;

import java.util.Scanner;
import java.util.ArrayList;

public class Admin extends Person {
    private static Admin instance;
    private final ArrayList<Student> students;
    private final ArrayList<Doctor> doctors;

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

        MenuPrinter.addUserMenu();

        int choice = scanner.nextInt();
        scanner.nextLine();

        String[] data = MenuPrinter.dataInput();

        switch(choice) {
            case 1:
                addDoctor(data[0], data[1], data[2]);
                break;
            case 2:
                addStudent(data[0], data[1], data[2]);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }
    private void addDoctor(String name, String email, String password) {
        Doctor doc = new Doctor(name, email, password);
        doctors.add(doc);
        System.out.println("Doctor added: " + doc.getName() + " (ID: " + doc.getID() + ")");
    }
    private void addStudent(String name, String email, String password) {
        Student std = new Student(name, email, password);
        students.add(std);
        System.out.println("Student added: " + std.getName() + " (ID: " + std.getID() + ")");
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

    public void removeUser() {
        Scanner scanner = new Scanner(System.in);
        boolean userRemoved = false;
        int attempts = 0;

        while (attempts < 3 && !userRemoved) {
            System.out.print("Enter the ID of the user to remove: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            User userToRemove = null;

            if ((userToRemove = findStudentById(id)) != null || (userToRemove = findDoctorById(id)) != null) {
                System.out.println("Are you sure you want to delete the user with ID " + id + "? (yes/no): ");
                String confirmation = scanner.nextLine();

                if (confirmation.equalsIgnoreCase("yes")) {
                    if (userToRemove instanceof Student) {
                        removeStudent((Student) userToRemove, id);
                    } else if (userToRemove instanceof Doctor) {
                        removeDoctor((Doctor) userToRemove, id);
                    }
                    userRemoved = true;
                } else {
                    System.out.println("User removal canceled.");
                    userRemoved = true;
                }
            } else {
                attempts++;
                System.out.println("No user found with ID " + id + ". Attempts remaining: " + (3 - attempts) + "\n");
            }
        }

        if (!userRemoved) {
            System.out.println("Failed to remove user after 3 attempts.");
        }
    }
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getID() == id) {
                return student;
            }
        }
        return null;
    }
    private Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getID() == id) {
                return doctor;
            }
        }
        return null;
    }
    private void removeStudent(Student userToRemove, int id) {
        students.remove(userToRemove);
        System.out.println("Student with ID " + id + " has been removed.");
    }
    private void removeDoctor(Doctor userToRemove, int id) {
        doctors.remove(userToRemove);
        System.out.println("Doctor with ID " + id + " has been removed.");
    }

}
