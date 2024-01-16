package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersProblem {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringNew("abcabcd")); //4 abcd
        System.out.println(lengthOfLongestSubstringNew("abcabcbb")); //3 abc
        System.out.println(lengthOfLongestSubstringNew("abcabcbb")); //3 abc
        System.out.println(lengthOfLongestSubstringNew("bbbbb")); //1 b
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        Map<Character, Integer> visitedCharacters = new HashMap<>();

        for (int right = 0, left = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (visitedCharacters.containsKey(ch) && visitedCharacters.get(ch) >= left) {
                left = visitedCharacters.get(ch) + 1;
            }
            //calculate max length substring
            maxLength = Math.max(maxLength, (right - left + 1));

            visitedCharacters.put(ch, right);
        }

        return maxLength;
    }

    private static int lengthOfLongestSubstringFast(String str) {
        int maxLength = 0;
        for (int right = 0, left = 0; right < str.length(); right++) {
            int indexOfFirstAppearanceInSubString = str.indexOf(str.charAt(right), left);
            if (indexOfFirstAppearanceInSubString != right) {
                left = indexOfFirstAppearanceInSubString + 1;
            }
            maxLength = Math.max(maxLength, (right - left + 1));
        }
        return maxLength;
    }

    private static int lengthOfLongestSubstringNew(String str) {
        int maxLength = 0;
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            int next = str.charAt(i);
            int prev = str.charAt(i - 1);
            if((next - prev) != 1) {
                count = 0;
            } else {
                count++;
            }
            maxLength = Math.max(maxLength, count + 1);
        }
        return maxLength;
    }
}
