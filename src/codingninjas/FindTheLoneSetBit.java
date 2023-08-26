package codingninjas;

public class FindTheLoneSetBit {

    public static void main(String[] args) {
        System.out.println(findSetBit(16)); //5
        System.out.println(findSetBit(21)); //-1
        System.out.println(findSetBit(32)); //6
        System.out.println(findSetBit(58)); //-1
        System.out.println(findSetBit(64)); //7
    }

    public static int findSetBit(int n) {
        if (n == 0) return -1;
        if (n % 2 != 0) return -1;
        double log2 = Math.log(n) / Math.log(2);
        double diff = log2 - (int) log2;
        if (diff > 0.0) {
            return -1;
        } else {
            return (int) log2;
        }
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

}
