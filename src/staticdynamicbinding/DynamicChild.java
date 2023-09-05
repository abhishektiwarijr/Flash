package staticdynamicbinding;

class DynamicChild extends DynamicParent {
    @Override
    void instanceMethod() {
        System.out.println("Instance method in Child");
    }
}