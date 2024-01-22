import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerThreadExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        List<Thread> producers = new ArrayList<>();
        List<Thread> consumers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(buffer);
            producers.add(producer);
        }
        for (int i = 0; i < 1; i++) {
            Consumer consumer = new Consumer(buffer);
            consumers.add(consumer);
        }

        producers.forEach(Thread::start);
        consumers.forEach(Thread::start);

//        while (true) {
//        }
    }
}

class Buffer {
    private Object[] items;
    private int head = 0;
    private int tail = 0;
    public Buffer(int size) {
        items = new Object[size];
    }

    public synchronized void produce(Object item) throws InterruptedException {
        while ((tail + 1) % items.length == head) {
            wait(); // Buffer full, wait for consumer
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        notifyAll(); // Buffer has item, notify consumer
    }

    public synchronized Object consume() throws InterruptedException {
        while (head == tail) {
            wait(); // Buffer empty, wait for producer
        }
        Object item = items[head];
        head = (head + 1) % items.length;
        notifyAll(); // Buffer has space, notify producer
        return item;
    }
}

class Producer extends Thread {
    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Object item = new Object();
            try {
                buffer.produce(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object item = buffer.consume();
                System.out.println(item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}