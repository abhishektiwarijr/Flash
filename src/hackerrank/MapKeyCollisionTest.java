package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapKeyCollisionTest {
    public static void main(String[] args) {
//        List<Interview> nl = new ArrayList<Interview>();
//        nl.add(new Interview());

        Map<Interview, String> map = new HashMap<>();
        Interview iv = new Interview();

        map.put(new Interview(), "a");
        map.put(new Interview(), "a");
        map.put(new Interview(), "b");
        map.put(new Interview(), "c");

        //Duplicate map key
        map.put(iv, null);
        map.put(iv, "s1"); //overwritten
        map.put(iv, "s2"); //overwritten

        System.out.println(map.size());
        System.out.println(map.get(iv));
    }

    private static class Interview {
        public int hashCode() {
            return 1;
        }
    }
}