package uplers;

import java.util.function.IntUnaryOperator;

class Solution {
    public static void main(String[] args) {
//        int[] input = {1, 0, 0, 1, 1};
//        int[] input = {1, 0, 0, 1, 1, 1}; //101011
//        for (int i : solution(input)) {
//            System.out.print(i);
//        }

        System.out.println(decimalToBaseNeg2(-11));
    }
    public static int[] solution(int[] A) {
        int x = 0;
        for (int i = 0; i < A.length; i++) {
            int pow = (int) Math.pow(-2.0, i);
            x = x + (pow * A[i]);
        }
        int y = (int) Math.ceil(x/2.0);

        StringBuilder res = new StringBuilder();
        while (y != 0) {
            res.append(y & 1);
            y = -(y >> 1);
        }

        int[] result = new int[res.length()];
        String[] strArr = res.toString().split("");
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strArr[i]);
        }

        return result;

    }

    public static String decimalToBaseNeg2(int decimalNumber) {
        if (decimalNumber == 0) return "0";

        StringBuilder baseNeg2 = new StringBuilder();
        while (decimalNumber != 0) {
            int remainder = decimalNumber % (-2);
            decimalNumber /= -2;

            if(remainder < 0) {
                remainder += 2;
                decimalNumber += 1;
            }
            baseNeg2.append(remainder);
//            baseNeg2.insert(0, remainder);
        }
        return baseNeg2.toString();
    }
}