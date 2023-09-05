public class CovarianceTest {
    public static void main(String[] args) {

    }

    private class Animal {
        protected int getLegsCount() {
            return 2;
        }
    }

    private class Dog extends Animal {
        @Override
        public int getLegsCount() {
            return 4;
        }
    }
}
