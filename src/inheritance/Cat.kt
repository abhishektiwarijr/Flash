package inheritance

class Cat : Animal() {
    override val name: String = "Cat"
    override fun makeNoise() {
        println("Meow..!")
    }
}