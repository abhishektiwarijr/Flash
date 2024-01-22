public final class SingletonClassJetBrainsWay {
    public static final SingletonClassJetBrainsWay sInstance;

    private SingletonClassJetBrainsWay() {}

    static {
        SingletonClassJetBrainsWay instance = new SingletonClassJetBrainsWay();
        sInstance = instance;
    }
}