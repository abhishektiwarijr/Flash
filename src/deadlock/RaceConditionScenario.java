package deadlock;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionScenario {
    private static volatile int sharedCounter = 0;

//    private static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 10000; i++) {
                //Race condition can occur here
//                synchronized (lock) {
                    sharedCounter++;
//                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + sharedCounter);
    }
}
