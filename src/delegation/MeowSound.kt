package delegation

class MeowSound : ISoundBehavior {
    override fun makeSound() {
        println("Meow..!")
    }
}