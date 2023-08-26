import java.util.Arrays;
import java.util.Collections;

public class ToggleKBitsProblem {

    public static void main(String[] args) {
        System.out.println(toggleKBits(21, 3)); //18
        System.out.println(toggleKBits(40, 4)); //39

        System.out.println(toggleKBits(5, 3)); //2
        System.out.println(toggleKBits(14, 3)); //9
        System.out.println(toggleKBits(20, 6)); //43
    }

    public static int toggleKBits(int n, int k) {
        //convert to binary
        int[] binary = new int[32];
        Arrays.fill(binary, 0);

        int j = 0;
        while (n > 0) {
            int bit = n % 2;
            binary[j] = bit;
            n = n / 2;
            j++;
        }

        //toggle last k bits
        for (int i = 0; i < k; i++) {
            if (binary[i] == 0) {
                binary[i] = 1;
            } else {
                binary[i] = 0;
            }
        }

        //convert back binary to decimal
        StringBuilder sb = new StringBuilder();
        for (int i = binary.length - 1; i >= 0 ; i--) {
            sb.append(binary[i]);
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
