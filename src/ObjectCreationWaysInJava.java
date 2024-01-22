import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ObjectCreationWaysInJava {
    public static void main(String[] args) {
        //1
        Universe universe1 = new Universe();

        //2
        try {
            Class<?> universeClass = Class.forName("src/Universe.java");
            Universe universe2 = (Universe) universeClass.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //3
        Universe universe3 = universe1.clone();

        //4
        try {
            Constructor<Universe> constructor = Universe.class.getDeclaredConstructor();
            Universe universe4 = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        //5
        Supplier<Universe> supplier = Universe::new;
        Universe universe5 = supplier.get();

        //6
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("serialized state (usually stored in a file or stream)")));
            Universe universe6 = (Universe) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
