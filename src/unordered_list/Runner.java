package unordered_list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

    public static void main(String[] args) {
        UnorderedList<Integer> uol = new UnorderedList<>();
        uol.add(1);
        uol.add(2);
        uol.add(3);
        uol.add(4);
        uol.add(5);
        uol.add(6);
        uol.add(7);
        uol.add(8);
        uol.add(9);
        uol.add(10);
        System.out.println(uol.capacity());
        uol.add(11);
        System.out.println(uol.capacity());

        Iterator<Integer> itr = uol.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
        }
    }
}
