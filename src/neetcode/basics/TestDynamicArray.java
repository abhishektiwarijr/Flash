package neetcode.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDynamicArray {

    public static void main(String[] args) {
        List<TestCase> testCases = getTestCases();
//        byte b_pos = 127;
//        byte b_neg = -128;
//        short s_pos = 32767;
//        short s_neg = -32768;
//        int i_pos = 2147483647;
//        int i_neg = -2147483648;
//        long l_pos = 9_223_372_036_854_775_807;
//        long l_neg = -9_223_372_036_854_775_808;
//        float f = 1f;
//        double d = 0.0;
//        char ch = '1';
//        boolean b = true;
//        String s = "abc";



        for (TestCase testCase : testCases) {
            String lastAction = "";
            DynamicArray dynamicArray = null;
            List<Object> output = new ArrayList<>();
            int indexValue = -1;
            for (Object object : testCase.input()) {
                if (object instanceof String) {
                    lastAction = (String) object;
                    switch (lastAction) {
                        case "getSize":
                            if (dynamicArray != null) {
                                output.add(dynamicArray.getSize());
                            }
                            break;
                        case "getCapacity":
                            if (dynamicArray != null) {
                                output.add(dynamicArray.getCapacity());
                            }
                            break;
                        case "popback":
                            if (dynamicArray != null) {
                                output.add(dynamicArray.popback());
                            }
                            break;
                    }
                } else if (object instanceof Integer) {
                    int value = (int) object;
                    switch (lastAction) {
                        case "Array":
                            dynamicArray = new DynamicArray(value);
                            output.add(null);
                            break;

                        case "pushback":
                            if (dynamicArray != null) {
                                dynamicArray.pushback(value);
                                output.add(null);
                            }
                            break;
                        case "get":
                            if (dynamicArray != null) {
                                output.add(dynamicArray.get(value));
                            }
                            break;
                        case "set":
                            if (indexValue == -1) {
                                indexValue = value;
                            } else {
                                if (dynamicArray != null) {
                                    dynamicArray.set(indexValue, value);
                                    output.add(null);
                                }
                            }
                            break;
                    }
                }
            }
            System.out.println(output.equals(testCase.output()));
        }
    }

    private static List<TestCase> getTestCases() {
        return List.of(
                new TestCase(List.of("Array", 1, "getSize", "getCapacity"), Arrays.asList(null, 0, 1)),
                new TestCase(List.of("Array", 5, "getSize", "getCapacity"), Arrays.asList(null, 0, 5)),
                new TestCase(List.of("Array", 3, "pushback", 1, "pushback", 2, "pushback", 3, "get", 0, "get", 1, "get", 2), Arrays.asList(null, null, null, null, 1, 2, 3)),
                new TestCase(List.of("Array", 4, "pushback", 1, "set", 0, 0, "pushback", 2, "get", 0, "get", 1, "getCapacity", "popback"), Arrays.asList(null, null, null, null, 0, 2, 4, 2)),
                new TestCase(List.of("Array", 5, "pushback", 1, "pushback", 2, "pushback", 3, "popback", "popback", "get", 0), Arrays.asList(null, null, null, null, 3, 2, 1)),
                new TestCase(List.of("Array", 2, "pushback", 0, "pushback", 1, "pushback", 2, "getSize", "getCapacity"), Arrays.asList(null, null, null, null, 3, 4)),
                new TestCase(List.of("Array", 3, "pushback", 0, "pushback", 1, "pushback", 2, "getSize", "getCapacity"), Arrays.asList(null, null, null, null, 3, 3)),
                new TestCase(List.of("Array", 5, "pushback", 2, "pushback", 4, "set", 0, 0, "get", 0, "get", 1, "getSize", "getCapacity"), Arrays.asList(null, null, null, null, 0, 4, 2, 5)),
                new TestCase(List.of("Array", 1, "pushback", 1, "getCapacity", "pushback", 2, "getCapacity"), Arrays.asList(null, null, 1, null, 2)),
                new TestCase(List.of("Array", 1, "getSize", "getCapacity", "pushback", 1, "getSize", "getCapacity", "pushback", 2, "getSize", "getCapacity", "get", 1, "set", 1, 3, "get", 1, "popback", "getSize", "getCapacity"), Arrays.asList(null, 0, 1, null, 1, 1, null, 2, 2, 2, null, 3, 3, 1, 2)),
                new TestCase(List.of("Array", 1, "getSize", "getCapacity", "pushback", 1, "pushback", 2, "pushback", 3, "pushback", 4, "pushback", 5, "pushback", 6, "pushback", 7, "pushback", 8, "pushback", 9, "getSize", "getCapacity", "popback", "popback", "popback", "popback", "popback", "popback", "popback", "popback", "popback", "getSize", "getCapacity"), Arrays.asList(null, 0, 1, null, null, null, null, null, null, null, null, null, 9, 16, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 16))
        );
    }
}

record TestCase(List<Object> input, List<Object> output) { }
