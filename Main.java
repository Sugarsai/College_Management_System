import UserClasses.*;
import AdminClasses.*;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();

        // Try to add students
        admin.addUser();
        admin.addUser();

        // List students
        admin.listStudents();
    }
}
