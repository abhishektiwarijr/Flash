public class IllegalMonitorExample {
    public static void main(String[] args) {
        Object obj = new Object();

        try {
            obj.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
