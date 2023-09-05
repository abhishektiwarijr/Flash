package annotations;

public class Dog {
    private String name;
    public Dog(String name) {
        this.name = name;
    }
    public void woof() {
        System.out.println("Woof..!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
