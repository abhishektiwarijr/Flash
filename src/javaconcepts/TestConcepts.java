package javaconcepts;

public class TestConcepts {
    public static void main(String[] args) {
        //1. The primary constructor for the data class must have at least one parameter.
        //2. The val or var must be used for all primary constructor parameters.
        //3. Abstract, open, sealed, or inner data classes are impossible.
        //4. Data classes can only implement interfaces.

        Animal animal = new Elephant("Elephant Jumbo");
        System.out.println(animal.getName());
    }
}
