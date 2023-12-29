import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballGameTest {

    public static int calPoints(String[] ops) {
        int result = Integer.MIN_VALUE;
        List<String> record = new ArrayList<>();

        for (String op : ops) {
            switch (op) {
                case "C":
                    record.remove(record.size() - 1);
                    break;
                case "D":
                    int last = Integer.parseInt(record.get(record.size() - 1));
                    String doubledLast = String.valueOf(2 * last);
                    record.add(doubledLast);
                    break;
                case "+":
                    int firstLast = Integer.parseInt(record.get(record.size() - 1));
                    int secondLast = Integer.parseInt(record.get(record.size() - 2));
                    String addTwoLast = String.valueOf(firstLast + secondLast);
                    record.add(addTwoLast);
                    break;
                default:
                    record.add(op);
                    break;
            }
        }

        result = 0;
        for (String s : record) {
            result = result + Integer.parseInt(s);
        }

        return result;
    }

    public static void main(String[] args) {
        //5 2 C D +
        Scanner sc = new Scanner(System.in);
        String[] ops = sc.nextLine().split(" ");
        System.out.println(BaseballGameTest.calPoints(ops));
    }
}
