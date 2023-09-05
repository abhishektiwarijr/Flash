public class DataShadowingExample {

    private int x = 10;

    public void shadowMethod() {
        int x = 20;
        System.out.println("Inner shadowed x =" + x);
    }

    public void printOuterX() {
        System.out.println("Outer x =" + x);
    }

    public static void main(String[] args) {
        DataShadowingExample dse = new DataShadowingExample();
        dse.shadowMethod();
        dse.printOuterX();
    }
}
