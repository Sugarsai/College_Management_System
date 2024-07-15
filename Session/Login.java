package Session;

import AdminClasses.*;
import Gen.Person;
import UserClasses.*;

import java.util.Scanner;

public class Login {
    private Admin admin;
    private Scanner scanner;

    public Login() {
        this.admin = Admin.getInstance();
        this.scanner = new Scanner(System.in);
    }

    public Person authenticateUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (admin.login(email, password)) {
            return admin;
        }

        for (Student student : admin.getStudents()) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return student;
            }
        }

        for (Doctor doctor : admin.getDoctors()) {
            if (doctor.getEmail().equals(email) && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }

        return null;
    }
}

