public class StringInternProblem {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = new String("hello").intern();
        String s3 = new String("hello").intern();
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
    }
}
