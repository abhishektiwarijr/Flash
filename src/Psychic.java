import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Psychic {
//    private static final long seed = System.currentTimeMillis();
    private static final Random random = new Random();
    private static AtomicLong seed;

    static {
        setup();
    }

    private static void setup() {
        try {
            Class<?> randomGeneratorClass = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");
            Field randomNumberGeneratorField = randomGeneratorClass.getDeclaredField("randomNumberGenerator");
            randomNumberGeneratorField.setAccessible(true);
            Random random1 = (Random) randomNumberGeneratorField.get(randomGeneratorClass);

            Field fieldSeed = random1.getClass().getDeclaredField("seed");
            fieldSeed.setAccessible(true);
            seed = (AtomicLong) fieldSeed.get(random1);

//            random1.setSeed(seed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double predict() throws Exception {
        Random rand = new Random();
        Field field = rand.getClass().getDeclaredField("seed");
        field.setAccessible(true);
        field.set(rand, new AtomicLong(seed.get()));
        return rand.nextDouble();
    }

    public static double guess() {
        return random.nextDouble();
    }

    public static void main(String[] args) {
        double guess = 0;
        try {
            guess = predict();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        double choice = Math.random();
        System.out.println(choice == guess);
    }
}

//https://github.com/esotericpig/codewars/blob/master/java/Psychic.java
//https://github.com/rubasace/codewars-katas/blob/master/src/main/java/com/rubasace/codewars/katas/Psychic.java