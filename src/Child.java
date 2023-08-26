
public class Child extends Parent {
    @Override
    public Child getThis() throws NullPointerException {
        return this;
    }
}
