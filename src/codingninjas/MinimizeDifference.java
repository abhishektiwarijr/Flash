package codingninjas;

public class MinimizeDifference {

    public static void main(String[] args) {
//        int[] input = {1, 2, 3, 4, 5};
//        System.out.println(minimizeIt(input, 2));

        System.out.println(minimizeIt(new int[]{10, 4, 20, 19, 9, 4, 20, 14, 15, 10, 9, 15, 8}, 9)); //14
        System.out.println(minimizeIt(new int[]{11, 9, 12, 16, 1, 14, 17, 14, 12, 11, 10, 3, 3, 9, 15, 4, 8}, 7)); //10
        System.out.println(minimizeIt(new int[]{3, 19, 4, 16, 17, 5, 7, 16, 3, 20, 1, 20, 10, 10, 2, 19, 13, 13}, 5)); //9
        System.out.println(minimizeIt(new int[]{2, 1, 19, 19, 11, 3, 7, 7, 14, 14, 4, 20, 1, 4, 9, 20, 19}, 7)); //11
        System.out.println(minimizeIt(new int[]{5, 17, 15, 4, 11, 15, 19, 18, 7, 14}, 7)); //10

    }

    public static int minimizeIt(int[] A, int K) {
        int N = A.length;

        int min = A[0];
        int max = A[0];

        for (int j : A) {
            min = Math.min(min, j);
            max = Math.max(max, j);
        }

        int currMinDiff = max - min;

        int[] cA = A.clone();
        int newMin = cA[0];
        int newMax = cA[0];
        int seed = 1;
        int i = 0;


        while (i < N) {
            if (cA[i] >= (K + seed)) {
                cA[i] = cA[i] - K;
            } else {
                cA[i] = cA[i] + K;
            }

            newMin = Math.min(newMin, cA[i]);
            newMax = Math.max(newMax, cA[i]);

            if (i == N - 1) {
                //check for minDiff
                if ((newMax - newMin) <= currMinDiff) {
                    break;
                } else {
                    seed++;
                    cA = A.clone();
                    newMin = cA[0];
                    newMax = cA[0];
                    i = -1;
                }
            }
            i++;
        }


        return (newMax - newMin);

    }
}
