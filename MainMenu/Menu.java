package MainMenu;

import AdminClasses.*;
import Gen.Person;
import UserClasses.*;
import Session.*;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Logout logout;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Login login = new Login();

        Person user = null;
        while (user == null) {
            user = login.authenticateUser();
            if (user == null) {
                System.out.println("Invalid email or password. Please try again.");
            }
        }

        if (user instanceof Admin) {
            displayAdminMenu((Admin) user);
        } else if (user instanceof Student) {
            displayStudentMenu((Student) user);
        } else if (user instanceof Doctor) {
            displayDoctorMenu((Doctor) user);
        }

        System.out.println("Logged out successfully.");
        start();
    }

    public void displayAdminMenu(Admin admin) {
        int choice = 0;
        while (choice != 6) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add User");
            System.out.println("2. Add Course");
            System.out.println("3. Assign Doctor to a Course");
            System.out.println("4. View Courses");
            System.out.println("5. Remove User");
            System.out.println("6. Log out");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    admin.addUser();
                    break;
                case 2:
                    //Add Course
                    break;
                case 3:
                    //Assign Doctor to a Course
                    break;
                case 4:
                    //View Courses
                    break;
                case 5:
                    //Remove User
                    break;
                case 6:
                    logout = new Logout(admin);
                    logout.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayStudentMenu(Student student) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nStudent Menu");
            System.out.println("1. Register in Courses");
            System.out.println("2. List My Courses");
            System.out.println("3. View a Course");
            System.out.println("4. Get Grades Report");
            System.out.println("5. Log out");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Register in Courses
                    break;
                case 2:
                    // List My Courses
                    break;
                case 3:
                    // View a Course
                    break;
                case 4:
                    // Get Grades Report
                    break;
                case 5:
                    logout = new Logout(student);
                    logout.logout(); // Logout when option 5 is selected
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayDoctorMenu(Doctor doctor) {
        int choice = 0;
        while (choice != 3) {
            System.out.println("\nDoctor Menu");
            System.out.println("1. List Courses");
            System.out.println("2. View a Course");
            System.out.println("3. Log out");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // List Courses
                    break;
                case 2:
                    // View a Course
                    break;
                case 3:
                    logout = new Logout(doctor);
                    logout.logout();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}