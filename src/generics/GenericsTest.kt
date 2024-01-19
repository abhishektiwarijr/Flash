package generics

class CovarianceSample<T>
class ContraVarianceSample<T>

open class Vehicle
class BiCycle : Vehicle()

//fun main() {
//covariance
//    val firstSample : CovarianceSample<Any> = CovarianceSample<Int>()
val secondSample: CovarianceSample<out Any> = CovarianceSample<Int>()
//    val thirdSample : CovarianceSample<out Int> = CovarianceSample<Any>()

//contravariance
val containerBiCycle: ContraVarianceSample<in BiCycle> = ContraVarianceSample<Vehicle>()
//    val containerVehicle : ContraVarianceSample<in Vehicle> = ContraVarianceSample<BiCycle>()

//invariance
val number2: List<Number> = listOf<Int>()
//}

private fun <T> printAnimal(animal: T) {
    println(animal)
}


interface AnimalCare<in T> {
    fun takeCareOf(animal: T)
}

class Vet : AnimalCare<AnimalX> {
    override fun takeCareOf(animal: AnimalX) {
        // do something
    }
}

open class AnimalX

class DogX : AnimalX()

fun main() {
    val animalCare: AnimalCare<DogX> = Vet()
    animalCare.takeCareOf(DogX())

    val fruitProducer = FruitProducer()
    println(fruitProducer.produce())
}

interface Producer<out T> {
    fun produce(): T
}

open class Fruit
class Apple : Fruit()
class Orange : Fruit()

class FruitProducer : Producer<Fruit> {
    override fun produce(): Fruit {
        return Apple()
    }
}

fun <T> addNumbers(a: T, b: T) where T : Number {
    val result = a.toDouble() + b.toDouble()
    println("Result: $result")
}

fun <T> processList(list: List<T>) where T : CharSequence, T : Comparable<T> {
    val sortedList = list.sorted()
    sortedList.forEach(::println)
}