package inheritance

class Dog : Animal() {
    override val name: String = "Dog"
    override fun makeNoise() {
        println("Bark..!")
    }
}