import java.text.NumberFormat;
import java.util.Objects;

class HelloWorld {
    public static void main(String[] args) {
        Long longValue = 123L;
//        System.out.println(longValue == 123);
//        System.out.println(Objects.equals(longValue, 123));
        parseFloat();
    }

    public static void parseFloat() {
        float weight = 12.5f;
        float result = weight - (int) weight;
        if (result != 0) {
            System.out.println("" + weight);
        } else {
            System.out.println(""+ ((int)weight));
        }

//        System.out.println(NumberFormat.getInstance().format(myNumber));
//        myNumber = 12.5f;
//        System.out.println(NumberFormat.getInstance().format(myNumber));
    }

}