package delegation

class Cat(soundBehavior: ISoundBehavior) : ISoundBehavior by soundBehavior {
    override fun makeSound() {
        println("Modified Meow!")
    }
}