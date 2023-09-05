package codingninjas;

import kotlin.Pair;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class GenerateAllValidStrings {

    public static void main(String[] args) {
        ArrayList<String> result = minRemovalToMakeStringValid("()(()"); //()() or (())
//        ArrayList<String> result = minRemovalToMakeStringValid("()())"); //()() or (())
//        ArrayList<String> result = minRemovalToMakeStringValid("()(x))()"); //()(x)() or ((x))() or (((x))) or ()((x))

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> minRemovalToMakeStringValid(String str) {
        Deque<Pair<Integer, Character>> stack = new ArrayDeque<Pair<Integer, Character>>();

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(' -> stack.push(new Pair<>(i, ')'));
                case ')'-> stack.pop();
            }
        }

        if(!stack.isEmpty()) { //remove the bad characters
            for (Pair<Integer, Character> p : stack) {
                int index = p.component1();
                str = str.substring(0, index) + str.substring(index+1);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        result.add(str);
        return result;
    }

    boolean isValidParenthesis(String s) {
        if ((s.length() & 1) == 1) return false;
        else {
            Deque<Character> p = new ArrayDeque<>(s.length());
            for (int i = 0; i < s.length(); i++)
                switch (s.charAt(i)) {
                    case '(' -> p.push(')');
                    case '{' -> p.push('}');
                    case '[' -> p.push(']');
                    case ')', '}', ']' -> {
                        if (p.isEmpty() || p.pop() != s.charAt(i)) return false;
                    }
                }
            return p.isEmpty();
        }
    }
}
