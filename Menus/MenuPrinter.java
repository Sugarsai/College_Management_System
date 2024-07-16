package Menus;

import java.util.Scanner;

public class MenuPrinter {
    private static Scanner scanner = new Scanner(System.in);

    public MenuPrinter() {}

    public static void addUserMenu() {
        System.out.println("Select the type of user to add: ");
        System.out.println("1. Doctor");
        System.out.println("2. Student");
    }
    public static String[] dataInput() {
        System.out.println("Enter User name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        return new String[]{name, email, password};
    }
    public static void userEditProfileMenu() {
            System.out.println("What would you like to edit?");
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. Password");
            System.out.println("4. Add extra informations");
            System.out.println("5. Exit");
    }
    public static void extraInformationMenu() {
        System.out.println("Choose information to add:");
        System.out.println("1. Age");
        System.out.println("2. Gender");
        System.out.println("3. Phone");
        System.out.println("4. Address");
        System.out.println("5. Exit");
    }
}
