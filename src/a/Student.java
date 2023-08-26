package a;

public class Student {
    public String name;
    private String email;
    String rollNumber;
    protected String grade;

    public Student(String name, String email, String rollNumber, String grade) {
        this.name = name;
        this.email = email;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}
