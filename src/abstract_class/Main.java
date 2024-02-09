package abstract_class;
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Whiskers");
        
        dog.makeSound();
        dog.eat();
        
        cat.makeSound();
        cat.eat();
    }
}
