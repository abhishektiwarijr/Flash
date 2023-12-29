import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * These 4 links explains well
 * 1. <a href="https://stackoverflow.com/questions/62180717/confusion-reagrding-java-hashmap-collision">...</a>
 * 2. <a href="https://stackoverflow.com/questions/29192597/how-to-retrive-values-when-collision-occured-in-hashmap">...</a>
 * 3. <a href="https://stackoverflow.com/questions/62180717/confusion-reagrding-java-hashmap-collision">...</a>
 * 4. <a href="https://medium.com/@frankrao.usc/how-is-hash-collision-handled-in-hashmap-aee053ecd044">...</a>
 */

public class HashMapCollisionExample {

    public static void main(String[] args) {
        // Create a HashMap
        Map<CustomKey, String> hashMap = new HashMap<>(4);

        // Create two custom keys with the same hash code
        CustomKey key1 = new CustomKey(1);
        CustomKey key2 = new CustomKey(1);

        // Put values into the map
        hashMap.put(key1, "Value1");
        hashMap.put(key2, "Value2");

        // Retrieve values using the keys
        System.out.println("Value for key1: " + hashMap.get(key1));
        System.out.println("Value for key2: " + hashMap.get(key2));

        for (Map.Entry<CustomKey, String> customKeyStringEntry : hashMap.entrySet()) {
            System.out.println("Value for key: " + customKeyStringEntry);
        }
    }
}

// CustomKey class with a custom hashCode implementation
class CustomKey {
    private final int value;

    public CustomKey(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        // A simple hash code implementation for illustration purposes
        return 1; // All instances have the same hash code
    }

    @Override
    public boolean equals(Object obj) {
        // A simple equals implementation for illustration purposes
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomKey customKey = (CustomKey) obj;
        return value == customKey.value;
    }
}


