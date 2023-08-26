package b;

import a.Student;

public class TestAccessOutside extends Student {
    public TestAccessOutside(String name, String email, String rollNumber, String grade) {
        super(name, email, rollNumber, grade);
    }

    public static void main(String[] args) {
        TestAccessOutside s = new TestAccessOutside(
                "Abhishek",
                "abhishek.tiwari@bit.ac.in",
                "1300505001",
                "B"
        );
        System.out.println(s.name);
        System.out.println(s.grade);
    }
}
