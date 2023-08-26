package a;

public class TestAccess {
    public static void main(String[] args) {
        Student s = new Student(
                "Abhishek",
                "abhishek.tiwari@bit.ac.in",
                "1300505001",
                "B"
        );
        System.out.println(s.name);
        System.out.println(s.rollNumber);
    }
}
