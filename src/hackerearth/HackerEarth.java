package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerEarth {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputA = br.readLine().split("");
        String[] inputP = br.readLine().split("");

        int result = 0;
        for (int i = 0; i < inputA.length; i++) {
            if (inputA[i].equals(inputP[i])) {
                result++;
            }
        }

        System.out.println(result);
    }
}
