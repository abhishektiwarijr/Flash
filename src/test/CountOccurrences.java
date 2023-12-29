package test;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrences {

    public static void main(String[] args) {
        System.out.println(countOccurrences("occurrences"));
    }

    private static String countOccurrences(String str) {
        int n = str.length();

        int[] freq = new int[26];

        for (int i = 0; i < n; i++)
            freq[str.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int ocrIndex = str.charAt(i) - 'a';
            int ocr = freq[ocrIndex];
            if (ocr != 0) {
                sb.append(str.charAt(i));
                sb.append(ocr);
                freq[ocrIndex] = 0;
            }
        }
        return sb.toString();
    }

    public static String printCharactersWithFrequency(String s) {
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i))) {
                dict.put(s.charAt(i), dict.get(s.charAt(i)) + 1);
            } else {
                dict.put(s.charAt(i), 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        // Print characters and their
        // frequencies in same order
        // of their appearance
        for (int i = 0; i < s.length(); i++) {
            // Print only if this
            // character is not printed
            // before
            if (dict.get(s.charAt(i)) != 0) {
                sb.append(s.charAt(i));
                sb.append(dict.get(s.charAt(i)));

                // update frequency of str.charAt(i) to
                // 0 so that the same character is not
                // printed again
                dict.put(s.charAt(i), 0);
            }
        }
        return sb.toString();
    }
}
