public class ImmutableTest {

    public static void main(String[] args) {
        String s0 = "John";
        String s1 = new String("John").intern();
        String s2 = new String("John");
        System.out.println(s0 == s1);
        System.out.println(s1 == s2);

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
    }
}
