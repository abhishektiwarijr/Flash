public class Student {
    private int studentId;
    private String studentName;
    private int score;
    private String collegeName;
    public Student() {

    }
    public Student(int studentId, String studentName, String collegeName, int score) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.score = score;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
