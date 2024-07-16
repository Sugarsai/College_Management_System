package UserClasses;

import Gen.Person;
import Menus.MenuPrinter;

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

    // I made them void until the implementation
    public void listCourses() {}
    public void viewCourses() {}
}
