
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[4];

        for (int i = 0; i < 4; i++) {
            int studentId = Integer.parseInt(sc.nextLine());
            String studentName = sc.nextLine();
            int score = Integer.parseInt(sc.nextLine());
            String collegeName = sc.nextLine();
            students[i] = new Student();
            students[i].setStudentId(studentId);
            students[i].setStudentName(studentName);
            students[i].setScore(score);
            students[i].setCollegeName(collegeName);
        }
        String collegeNameByLowestScore = sc.nextLine();
        Student lowestByCollegeName = getLowestScoredStudentByCollegeName(students, collegeNameByLowestScore);

        if (lowestByCollegeName != null) {
            System.out.println(lowestByCollegeName.getStudentId());
            System.out.println(lowestByCollegeName.getStudentName());
            System.out.println(lowestByCollegeName.getScore());
            System.out.println(lowestByCollegeName.getCollegeName());
        } else {
            System.out.println("No such student found");
        }

        Student secondLargest = getSecondHighestScoredStudent(students);
        if (secondLargest != null) {
            System.out.println(secondLargest.getStudentId());
            System.out.println(secondLargest.getStudentName());
            System.out.println(secondLargest.getScore());
            System.out.println(secondLargest.getCollegeName());
        } else {
            System.out.println("No such student found");
        }
        sc.close();
    }

    public static Student getLowestScoredStudentByCollegeName(Student[] students, String collegeName) {
        Student smallest = students[0];
        boolean isCollegeMatched = false;
        for (Student student : students) {
            if (student.getCollegeName().equalsIgnoreCase(collegeName)) {
                isCollegeMatched = true;
                if (student.getScore() < smallest.getScore())
                    smallest = student;
            }
        }
        if (isCollegeMatched) {
            return smallest;
        } else return null;
    }

    public static Student getSecondHighestScoredStudent(Student[] students) {
        Student largest = students[0];
        Student secondLargest = students[0];
        boolean isSecondLargest = false;
        for (Student student : students) {
            if (student.getScore() > largest.getScore()) {
                secondLargest = largest;
                largest = student;
                isSecondLargest = true;
            } else if (student.getScore() > secondLargest.getScore()) {
                secondLargest = student;
                isSecondLargest = true;
            }
        }
        if (isSecondLargest && (secondLargest.getScore() % 2 == 1) && secondLargest.getScore() > 500) {
            return secondLargest;
        } else return null;
    }
}
