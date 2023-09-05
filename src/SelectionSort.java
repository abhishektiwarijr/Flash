import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        selectionSort(numbers);

        System.out.println("After:");
        printArray(numbers);
    }

    private static void selectionSort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length - 1; i++) {
            int currentLowestIndex = i;

            int j = i + 1;
            while (j < length) {
                if (numbers[j] < numbers[currentLowestIndex]) {
                    currentLowestIndex = j;
                }
                j++;
            }

            swap(numbers, i, currentLowestIndex);
        }
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
        System.out.println();
    }
}
