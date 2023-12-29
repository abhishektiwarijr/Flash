public class CovarianceTest {
    public static void main(String[] args) {

    }

    private class Animal {
        protected int getLegsCount() {
            return 2;
        }

        protected Animal reproduce() {
            System.out.println("Animal reproducing...");
            return new Animal();
        }
    }

    private class Dog extends Animal {
        @Override
        public int getLegsCount() {
            return 4;
        }

        @Override
        protected Dog reproduce() {
            return new Dog();
        }
    }
}
