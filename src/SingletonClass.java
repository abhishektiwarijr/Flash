import java.io.Serializable;

public class SingletonClass implements Serializable {
    private static volatile SingletonClass instance = null;

    private SingletonClass() {
        if(instance != null) {
            throw new RuntimeException("Instance already exist, can't create new one for Singleton");
        }
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public static synchronized SingletonClass getThreadSafeInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public static SingletonClass getInstanceByUsingDoubleCheckedLocking() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    public Object readResolve() {
        return instance;
    }
}
