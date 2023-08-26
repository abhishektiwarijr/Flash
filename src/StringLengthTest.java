public class StringLengthTest {

    public static void main(String[] args) {
        System.out.println(getLengthOfStringX("Abhishek"));
        System.out.println(getLengthOfString("Abhishek"));
    }

    public static int getLengthOfString(String str) {
        int i = 0;
        try {
            for (i = 0; ; i++) {
                str.charAt(i);
            }
        } catch (Exception ex) {
            return i;
        }
    }

    public static int getLengthOfStringX(String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count++;
        }
        return count;
    }
}
