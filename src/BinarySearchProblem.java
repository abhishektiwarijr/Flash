
public class BinarySearchProblem {

    public static void main(String[] args) {
        int length = 1200_000_00;
        int[] arr = new int[length];

        for(int i = 0; i < length; arr[i] = i++) {

        }

        long start = System.nanoTime();
        System.out.println(binarysearch(arr, 12));
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    private static boolean binarysearch(int[] arr, int target) {
        var lb = 0;
        var ub = arr.length - 1;

        while (lb != ub) {
            int mid = (lb + ub) / 2;

            int value = arr[mid];
            if (value < target) {
                lb = mid + 1;
                if(arr[lb] == target) {
                    return true;
                }
            } else if (value > target) {
                ub = mid - 1;
                if(arr[ub] == target) {
                    return true;
                }
            } else {
                return true;
            }
        }

        return false;
    }
}