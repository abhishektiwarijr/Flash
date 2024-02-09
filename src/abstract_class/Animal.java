package abstract_class;

/**
 * In the abstract class example, the Animal class has a constructor,
 * which interfaces cannot have.
 * Abstract classes can be used to share common constructor logic
 * among subclasses.
 *
 * The abstract class Animal has a concrete method eat(),
 * while the interface enforces that implementing classes
 * provide an implementation for both makeSound() and eat()
 *
 */
abstract class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public abstract void makeSound();
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
}
