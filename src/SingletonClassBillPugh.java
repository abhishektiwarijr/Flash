public class SingletonClassBillPugh {
    private SingletonClassBillPugh() {

    }

    private static class SingletonHelper {
        private static final SingletonClassBillPugh INSTANCE = new SingletonClassBillPugh();
    }

    public static SingletonClassBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
