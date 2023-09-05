import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[100_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000);
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("After:");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    private static void mergeSort(int[] numbers) {
        int inputLength = numbers.length;

        if (inputLength < 2) return;

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

//        System.arraycopy(numbers, 0, leftHalf, 0, midIndex);
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = numbers[i];
        }

//        System.arraycopy(numbers, midIndex, rightHalf, inputLength - midIndex, inputLength);
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = numbers[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //Merge these two sorted arrays to one large sorted array
        merge(numbers, leftHalf, rightHalf);
    }

    private static void merge(int[] numbers, int[] leftHalf, int[] rightHalf) {
        int leftHalfSize = leftHalf.length;
        int rightHalfSize = rightHalf.length;

        int i = 0, j = 0, k = 0;
        while (i < leftHalfSize && j < rightHalfSize) {
            if(leftHalf[i] <= rightHalf[j]) {
                numbers[k] = leftHalf[i];
                i++;
            } else {
                numbers[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //put elements in merge array if left any
        while (i < leftHalfSize) {
            numbers[k] = leftHalf[i];
            i++;
            k++;
        }

        //put elements in merge array if left any
        while (j < rightHalfSize) {
            numbers[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
