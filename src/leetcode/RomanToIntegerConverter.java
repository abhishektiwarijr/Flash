package leetcode;

import java.util.regex.Pattern;

public class RomanToIntegerConverter {
    public static void main(String[] args) {
        System.out.println(convertRomanToInteger("XIV"));
        System.out.println(convertRomanToInteger("MCMXCIV"));
    }
    
    public static int convertRomanToInteger(String romanNumeral) {
        // Define the valid Roman numeral pattern using regex
        String pattern = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        
        if (Pattern.matches(pattern, romanNumeral)) {
            int result = 0;
            String[] symbolValues = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            
            for (int i = 0; i < symbolValues.length; i++) {
                while (romanNumeral.startsWith(symbolValues[i])) {
                    result += intValues[i];
                    romanNumeral = romanNumeral.substring(symbolValues[i].length());
                }
            }
            
            return result;
        }
        
        return -1; // Invalid Roman numeral
    }
}
