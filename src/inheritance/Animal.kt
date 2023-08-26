package inheritance

abstract class Animal : Organism {

    init {
        println("Constructor Invoked")
    }

    open val name: String = "Animal"
    open fun makeNoise() {
        println("Some noise")
    }
}