package neetcode.basics;

class DynamicArray {
    private int[] array;
    private int capacity;
    private int size;

    // Constructor to initialize the dynamic array
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[this.capacity];
    }

    // Get value at the i-th index
    public int get(int i) {
        return array[i];
    }

    // Insert value n at the i-th index
    public void set(int i, int n) {
        array[i] = n;
    }

    // Insert n in the last position of the array
    public void pushback(int n) {
        ensureCapacity();
        array[size] = n;
        size++;

    }

    private void ensureCapacity() {
        if (size == capacity) {
            resize();
        }
    }

    // Remove the last element in the array
    public int popback() {
        int lastElement = -1;
        if (size > 0) {
            int lastIndex = size - 1;
            lastElement = array[lastIndex];
            array[lastIndex] = 0;
            size--;
        }
        return lastElement;
    }

    private void resize() {
        int[] oldArray = array;
        capacity *= 2;
        int[] newArray = new int[capacity];
        System.arraycopy(oldArray, 0, newArray, 0, size);
        array = newArray;
    }

    // Get the size of the array
    public int getSize() {
        return size;
    }

    // Get the capacity of the array
    public int getCapacity() {
        return capacity;
    }
}
