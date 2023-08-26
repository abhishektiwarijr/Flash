import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
//    public static void main(String[] args) {
//
//        List<String> list = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            list.add(String.valueOf(i));
//        }
//
//        int from = Math.max(list.size() - 3, 0); //5
//        int to = list.size(); //8
//
//        List<String> tail = list.subList(from, to);
//        for (String s : tail) {
//            System.out.println(s);
//        }
//
//        Double d = 859669126042.06396484375;
//        System.out.println(AppUtils.INSTANCE.formatValue(d));
//    }

    public static void main(String[] args) throws Exception {
//        System.out.println(0.1 + 0.2 == 0.3);
        TestPojo tp = new TestPojo();
        tp.setBtc("xyz");
        System.out.println (getValueOf(tp,"btc"));
    }

    @SuppressWarnings("rawtypes")
    public static Object getValueOf(Object clazz, String lookingForValue)
            throws Exception {
        Field field = clazz.getClass().getDeclaredField(lookingForValue);
        field.setAccessible(true);
        return field.get(clazz);
    }

}
