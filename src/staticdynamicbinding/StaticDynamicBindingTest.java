package staticdynamicbinding;

import java.io.IOException;
import java.util.ConcurrentModificationException;

public class StaticDynamicBindingTest {
    public static void main(String[] args) {
        //static binding - compile-time
        StaticParent staticParent = new StaticChild();
        staticParent.staticMethod();
        staticParent.finalMethod();

        //dynamic binding - run-time
        DynamicParent dynamicParent = new DynamicChild();
        dynamicParent.instanceMethod();
    }
}
