package Gen;

public abstract class Person {
    protected String email;
    protected String password;

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Abstract method for getting the name
    public abstract String getName();
}
