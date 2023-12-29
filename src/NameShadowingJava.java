public class NameShadowingJava {
    private int value;
    private String test;
    private String foo;
    public NameShadowingJava(int value, String test) {
        this.value = value;
        this.test = test;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}