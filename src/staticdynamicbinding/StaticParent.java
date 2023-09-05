package staticdynamicbinding;

class StaticParent {
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }

    final void finalMethod() { System.out.println("Final method in Parent"); }
}