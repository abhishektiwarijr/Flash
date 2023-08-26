import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
        Integer n1 = new Integer(500);
        Integer n2 = new Integer(500);

        System.out.println(n1.hashCode() == n2.hashCode());

        String s1 = new String("Hello");
        String s2 = new String("Hello");

        System.out.println(s1.hashCode() == s2.hashCode());
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "1");
    }
}
