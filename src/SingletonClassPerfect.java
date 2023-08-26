public class SingletonClassPerfect {
    private static volatile SingletonClassPerfect sSoleInstance;

    //private constructor.
    private SingletonClassPerfect() {
        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClassPerfect getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            synchronized (SingletonClassPerfect.class) {
                if (sSoleInstance == null) sSoleInstance = new SingletonClassPerfect();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected SingletonClassPerfect readResolve() {
        return getInstance();
    }

}
