import java.util.ArrayList;

public class Student extends User {
    private static int studentIdCounter = 20220100;
    //protected ArrayList<Course> courses;

    public Student(String name, String email, String password) {
        super(name, email, password);
        generateID();
    }

    @Override
    public void generateID() {
        this.ID = studentIdCounter++;
    }
    // I made all of them void until the implementation
    public void registerCourse() {}
    public void submitAssignment() {}
    public void getGradesReport() {}
}
