public class Doctor extends User {
    private static int doctorIdCounter = 169664;
    //protected ArrayList<Course> courses;

    public Doctor(String name, String email, String password) {
        super(name, email, password);
        generateID();
    }

    @Override
    public void generateID() {
        this.ID = doctorIdCounter++;
    }
    // I made all of them void until the implementation
    public void addAssignment() {}
    public void removeAssignment() {}
    public void viewAssignments() {}
    public void gradeStudentAssignment() {}
}
