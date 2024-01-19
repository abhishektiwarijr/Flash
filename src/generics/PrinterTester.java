package generics;

import java.util.ArrayList;
import java.util.List;

public class PrinterTester {
    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(27);
        integerPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(27.0);
        doublePrinter.print();

        Printer<String > stringPrinter = new Printer<>("Twenty Seven");
        stringPrinter.print();

        AnimalPrinter<Animal> animalPrinter = new AnimalPrinter<>(new Dog());
        animalPrinter.print();

        shout("What the duck!");
        shout(1);
        shout("What the duck!", 2);

        printList(new ArrayList<Integer>());
        printList(new ArrayList<Animal>());
    }

    private static <T> void shout(T thingToShoutAbout) {
        System.out.println(thingToShoutAbout);
    }

    private static <T, V> void shout(T oneThingToShout, V otherThingToShout) {
        System.out.println(oneThingToShout);
        System.out.println(otherThingToShout);
    }

    private static void printList(List<?> list) {
        System.out.println(list);
    }


}
