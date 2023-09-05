package inheritance;

public class Document implements Printable {

    @Override
    public void print() {
        System.out.println("Printing Document");
    }
}
