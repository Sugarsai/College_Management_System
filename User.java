import java.util.Scanner;

public abstract class User {
    protected int ID;
    protected String name;
    protected String email;
    protected String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public abstract void generateID();
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void editData() {
        Scanner scanner = new Scanner(System.in);

        editingMenu();

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                name = scanner.nextLine();
                this.name = name;
                break;
            case 2:
                System.out.print("Enter new email: ");
                email = scanner.nextLine();
                this.email = email;
                break;
            case 3:
                System.out.print("Enter new password: ");
                password = scanner.nextLine();
                this.password = password;
                break;
            case 4:
                System.out.print("Exiting editing menu... ");
                break;
            default:
                System.out.println("Invalid choice.");
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
