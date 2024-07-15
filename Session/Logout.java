package Session;

import Gen.Person;
import UserClasses.*;
import AdminClasses.*;

public class Logout {
    private Person currentUser;

    public Logout(Person currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        System.out.println("Logging out " + currentUser.getName() + "...");
        currentUser = null;
    }
    public Person getCurrentUser() {
        return currentUser;
    }
}
