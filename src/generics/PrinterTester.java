package generics;

public class PrinterTester {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(27);
        integerPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(27.0);
        doublePrinter.print();

        Printer<String > stringPrinter = new Printer<>("Twenty Seven");
        stringPrinter.print();
    }
}
