package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) {
        Cat myCat = new Cat("Stacey");
        Dog myDog = new Dog("Jack");

        //processing class annotation
        if (myCat.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This cat is very important");
        } else {
            System.out.println("This cat is not very important");
        }

        if (myDog.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println("This dog is very important");
        } else {
            System.out.println("This dog is not very important");
        }

        //processing method annotation
        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately ann = method.getAnnotation(RunImmediately.class);
                try {
                    for (int i = 0; i < ann.times(); i++) {
                        method.invoke(myCat);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //processing field annotation
        for (Field field : myCat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                try {
                    Object objectValue = field.get(myCat);
                    if (objectValue instanceof String) {
                        System.out.println(((String) objectValue).toUpperCase());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
