package delegation

fun main() {
    val cat = Cat(MeowSound())
    //Esto es Delegacion
    cat.makeSound()
}