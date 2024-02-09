package interfaces;

/**
 * While interfaces are powerful for defining contracts and
 * achieving a form of multiple inheritance,
 * abstract classes are more versatile and can include a broader
 * range of features, such as fields, constructors,
 * and concrete methods.
 * The choice between using an abstract class or an interface
 * depends on your specific requirements and design goals.
 * In some cases, you may use a combination of both to achieve
 * your objectives.
 * If you want to provide a common base class with shared behavior
 * and allow for customization, an abstract class is suitable.
 * If you want to define a contract that multiple classes can
 * adhere to, regardless of their inheritance hierarchy,
 * an interface is the better choice.
 */
interface Animal {
    void makeSound();
    void eat();
}