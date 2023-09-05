public class StaticMethodOverloadingTest {

    public static void main(String[] args) {
        System.out.println("Original Main");
        int sumInt = add(5, 3); // Calls the first overload
        double sumDouble = add(2.5, 3.7); // Calls the second overload
        String concatenatedStr = add("Hello, ", "world!"); // Calls the third overload

        System.out.println("Sum of integers: " + sumInt);
        System.out.println("Sum of doubles: " + sumDouble);
        System.out.println("Concatenated string: " + concatenatedStr);

    }

    public static void main() {
        System.out.println("No parameter Main");
    }

    public static void main(String[] args, int x) {
        System.out.println("Two parameters Main");
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static String add(String str1, String str2) {
        return str1 + str2;
    }
}
