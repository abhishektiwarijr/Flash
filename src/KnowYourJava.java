import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class KnowYourJava {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
//        example5();
        example6();
    }

    private static void example1() {
        System.out.println("Method Example 1");
        List<Integer> list = new ArrayList<Integer>(List.of(1, 2, 3));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
    private static void example2() {
        System.out.println("Method Example 2");
        Collection<Integer> list = new ArrayList<Integer>(List.of(1, 2, 3));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

    private static void example3() {
        System.out.println("Method Example 3");
        var list = new ArrayList<Integer>(List.of(1, 2, 3));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }

    private static void example4() {
        System.out.println("Method Example 4");
        //Not good to use asList instead use List.of()
        List<Integer> list = Arrays.asList(1, 2, 3);
        System.out.println(list);

        try {
            list.add(4);
            System.out.println("Added");
        } catch (Exception e) {
            System.out.println("Unsupported");
        }

        try {
            list.set(2, 2);
            System.out.println("Set");
        } catch (Exception e) {
            System.out.println("Unsupported");
        }

        System.out.println(list);
    }
    private static void example5() {
        while (true) {
            List<String> names = List.of("Jack", "Jill", "John", "Dory", "Emma", "Chris", "Thomas");
            List<String> inUpperCase = new ArrayList<>();

            names.parallelStream()
                    .map(String::toUpperCase)
                    .forEach(inUpperCase::add);

            System.out.println(names.size());
            System.out.println(inUpperCase.size());
        }
    }
    private static void example6() {
        int[] factor = new int[] { 2 };

        var numbers = List.of(1, 2, 3);

        var stream = numbers
                .stream()
                .map(number -> number * factor[0]);

        factor[0] = 0;

        stream.forEach(System.out::println);
    }
}
