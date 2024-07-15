package UserClasses;

import Gen.Person;

import java.util.Scanner;

public abstract class User extends Person {
    protected int ID;
    protected String name;
    private boolean isLoggedIn;

    public User(String name, String email, String password) {
        super(email, password);
        this.name = name;
    }

    public abstract void generateID();
    public int getID() {
        return ID;
    }
    @Override
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter email: ");
            String inputEmail = scanner.nextLine();
            System.out.print("Enter password: ");
            String inputPassword = scanner.nextLine();

            if (this.email.equals(inputEmail) && this.password.equals(inputPassword)) {
                isLoggedIn = true;
                System.out.println("Login successful!");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid email or password. Attempts remaining: " + attempts);
            }
        }
        return false;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);

        editingMenu();

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                this.name = scanner.nextLine();
                break;
            case 2:
                System.out.print("Enter new email: ");
                this.email  = scanner.nextLine();
                break;
            case 3:
                System.out.print("Enter new password: ");
                this.password = scanner.nextLine();
                break;
            case 4:
                System.out.print("Exiting editing menu... ");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
    }
    private void editingMenu() {
        System.out.println("What would you like to edit?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Password");
        System.out.println("4. Exit");
    }

    // I made them void until the implementation
    public void listCourses() {}
    public void viewCourses() {}
}
