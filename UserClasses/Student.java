package UserClasses;

import Menus.MainMenu;
import Menus.MenuPrinter;

import java.util.Scanner;

public class Student extends User {
    private static int studentIdCounter = 20220100;
    private int age;
    private String gender;
    private String phone;
    private String address;
    //protected ArrayList<Course> courses;

    public Student(String name, String email, String password) {
        super(name, email, password);
        generateID();
    }

    @Override
    public void generateID() {
        this.ID = studentIdCounter++;
    }

    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    public void editProfile() {
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 5) {

            MenuPrinter.userEditProfileMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    this.name = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter new email: ");
                    this.email = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter new password: ");
                    this.password = scanner.nextLine();
                    break;
                case 4:
                    editExtraInformation();
                    break;
                case 5:
                    System.out.print("Exiting editing menu... ");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
        }
    }
    public void editExtraInformation() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5){

            MenuPrinter.extraInformationMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your age: ");
                    this.age = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter your gender: ");
                    this.gender = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter your phone: ");
                    this.phone = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Enter your address: ");
                    this.address = scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Exiting extra information menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // I made all of them void until the implementation
    public void registerCourse() {}
    public void submitAssignment() {}
    public void getGradesReport() {}
}
