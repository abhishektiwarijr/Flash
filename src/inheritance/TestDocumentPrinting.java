package inheritance;

public class TestDocumentPrinting {

    public static void main(String[] args) {
        Printable document = new Document();
        document.print();
        document.log();
        Printable.info();
    }
}
