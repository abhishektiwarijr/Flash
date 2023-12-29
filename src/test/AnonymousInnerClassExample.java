package test;

public class AnonymousInnerClassExample {

    public static void main(String[] args) {
         int ageOld = 10;
        Age age = new Age() {
            @Override
            public void getAge() {
                System.out.println(ageOld);
            }
        };
        age.getAge();
    }
}
