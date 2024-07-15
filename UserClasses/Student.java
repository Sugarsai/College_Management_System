package UserClasses;

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

    public void addExtraInformations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter age: ");
        this.age = scanner.nextInt();

        System.out.println("Enter gender: ");
        this.gender = scanner.next();

        System.out.println("Enter phone: ");
        this.phone = scanner.next();

        System.out.println("Enter address: ");
        this.address = scanner.next();
    }

    // I made all of them void until the implementation
    public void registerCourse() {}
    public void submitAssignment() {}
    public void getGradesReport() {}
}
