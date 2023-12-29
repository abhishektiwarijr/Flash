import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        for (int num : productOfArrayExceptSelfJava(new int[]{1, 2, 3, 4 })) {
            System.out.print(num + ",");
        }
    }

    private static int[] productOfArrayExceptSelfJava(int[] nums) {
        //0. Naive Approach - Brute Force, Two for loops if i == j then don't multiply

        //1. Make a Prefix array
        //2. Make a Suffix array
        //3. Multiply them together
        int n = nums.length;
//        int[] prefix = new int[n];
//        prefix[0] = 1;
//        for(int i = 1; i <= n - 1; i++) {
//            prefix[i] = prefix[i - 1] * nums[i - 1];
//        }


        int[] product = new int[n];
        Arrays.fill(product, 1);

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i <= n - 1; i++) {
            product[i] = product[i] * prefix;
            prefix = prefix * nums[i];

            product[n - i - 1] = product[n - i - 1] * suffix;
            suffix = suffix * nums[n - i - 1];
        }


//        int[] product = new int[n];
//        int suffixProduct = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            product[i] = prefix[i] * suffixProduct;
//            suffixProduct = suffixProduct * nums[i];
//        }


//        int[] suffix = new int[n];
//        suffix[n - 1] = 1;
//        for (int i = n - 2; i >= 0; i--) {
//            suffix[i] = suffix[i + 1] * nums[i + 1];
//        }
//
//        int[] product = new int[n];
//        for (int i = 0; i <= n - 1; i++) {
//            product[i] = prefix[i] * suffix[i];
//        }

        return product;
    }
}