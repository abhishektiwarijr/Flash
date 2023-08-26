public class SubstringProblem {
    public static void main(String[] args) {
//        String str = "A man with no enemies is not a man at all";
//        System.out.println(str.substring(5, 5));

        String a = "Test";
        String b = "Test";
        String c = new String("Test");
        String d = new String("Test");

        System.out.println(a == b); //true
        System.out.println(a == c); //false
        System.out.println(c == d); //false
    }
}
