package deadlock;

public class CreateCircularLockDependency {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 and lock 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
           synchronized (lock2) {
               System.out.println("Thread 2: Holding lock 2");
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (lock1) {
                   System.out.println("Thread 2: Holding lock 2 and lock 1");
               }
           }
        });

        thread1.start();
        thread2.start();
    }
}

class ResourceA {
    private final Object lockA = new Object();

    public void accessB() {
        synchronized (lockA) {
            ResourceB resourceB = new ResourceB();
            resourceB.accessA();
        }
    }

}

class ResourceB {
    private final Object lockB = new Object();

    public void accessA() {
        synchronized (lockB) {
            ResourceA resourceA = new ResourceA();
            resourceA.accessB();
        }
    }
}