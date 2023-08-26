public class TestRunnable implements Runnable {
    int a = 0, b = 0;

    int incrementA() {
        return ++a;
    }
    int incrementB() {
        return ++b;
    }

    public void run() {
        for (int i = 0; i<3; i++) {
            System.out.println(incrementA() + "" + incrementB());
        }
    }

    public static void main(String[] args) {
        TestRunnable tr1 = new TestRunnable();
        TestRunnable tr2 = new TestRunnable();
        Thread t1 = new Thread(tr1);
        Thread t2 = new Thread(tr2);
        t2.start();
        t1.start();
    }
}
