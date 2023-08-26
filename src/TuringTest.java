import java.util.*;

public class TuringTest {
    public static void main(String[] args) {
//        String s = "red2 blue5 black4 green1 gold3";
//        Map<Integer, String> map = new HashMap<>();
//        for (String str : s.split(" ")) {
//            map.put(Integer.valueOf(str.charAt(str.length()-1)), str.substring(0, str.length() - 1));
//        }
//        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
//        StringBuilder result = new StringBuilder();
//        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
//            result.append(entry.getValue()).append(" ");
//        }
//
//        System.out.println(result.toString());




        int[] k = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        for (int i : sortByLeastRepeats(k)) {
            System.out.print(i);
        }
    }

    public static int[] sortByLeastRepeats(int[] k) {
        Map<Integer, Integer> occr = new HashMap<>();
        for (int num : k) {
            occr.put(num, occr.getOrDefault(num, 0) + 1);
        }

        Integer[] boxedArray = new Integer[k.length];
        for (int i = 0; i < k.length; i++) {
            boxedArray[i] = k[i];
        }

        Arrays.sort(boxedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                int count1 = occr.get(num1);
                int count2 = occr.get(num2);

                if (count1 == count2) {
                    return num2 - num1; // For equal occurrences, sort by value ascending.
                } else {
                    return count1 - count2; // Sort by occurrences ascending.
                }
            }
        });

        for (int i = 0; i < k.length; i++) {
            k[i] = boxedArray[i];
        }

        return k;
    }

    public static int[] sortByLeastRepeated(int[] arr) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort the array based on the frequency of occurrences
        Arrays.sort(arr);

        return arr;
    }
    private static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Element not found
    }
}


