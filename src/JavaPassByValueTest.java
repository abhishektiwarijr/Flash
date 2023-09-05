import annotations.Dog;
import sealed.D;

public class JavaPassByValueTest {
    public static void main(String[] args) {
        Dog dog = new Dog("Max");

        Dog oldDog = dog;

        // we pass the object to changeDog
        changeDog(dog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        System.out.println(dog.getName().equals("Max")); // true
        System.out.println(dog.getName().equals("Fifi")); // false
        System.out.println(dog == oldDog); //true


//        System.out.println(dog.getName());
//        changeDog(dog);
//        System.out.println(dog.getName());
    }

    private static void changeDog(Dog dog) {
        dog.getName().equals("Max"); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        dog = new Dog("Fifi");
        dog.getName().equals("Fifi"); // true

    }
}
