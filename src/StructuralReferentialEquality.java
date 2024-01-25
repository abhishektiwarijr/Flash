import java.util.ArrayList;
import java.util.List;

public class StructuralReferentialEquality {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 1; i <= 3; i++) {
            list1.add(i);
            list2.add(i);
        }

        System.out.println(arr1 == arr2);
        System.out.println(list1 == list2);
    }
}
