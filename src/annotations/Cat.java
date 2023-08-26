package annotations;

@VeryImportant
public class Cat {
    @ImportantString
    String name;
    public Cat(String name) {
        this.name = name;
    }
    @RunImmediately(times = 5)
    public void meow() {
        System.out.println("Meow..!");
    }

    public void eat() {
        System.out.println("Munch munch...");
    }
}
