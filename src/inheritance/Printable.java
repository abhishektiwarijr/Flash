package inheritance;

public interface Printable {
    void print();

    default void log() {
        System.out.println("Logging");
    }

    static void info() {
        System.out.println("Info");
    }
}
