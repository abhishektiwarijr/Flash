import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ValidParentheses {

    public static void main(String[] args) {
        //5 2 C D +
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (ValidParentheses.isValid(s)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }

    }

    private static boolean isValid(String expr) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++) {
            char currChar = expr.charAt(i);

            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check;
            switch (currChar) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
}
