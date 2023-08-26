package generics

class CovarianceSample<T>
class ContraVarianceSample<T>

open class Vehicle
class BiCycle : Vehicle()

fun main() {
    //covariance
//    val firstSample : CovarianceSample<Any> = CovarianceSample<Int>()
    val secondSample : CovarianceSample<out Any> = CovarianceSample<Int>()
//    val thirdSample : CovarianceSample<out Int> = CovarianceSample<Any>()

    //contravariance
    val containerBiCycle : ContraVarianceSample<in BiCycle> = ContraVarianceSample<Vehicle>()
//    val containerVehicle : ContraVarianceSample<in Vehicle> = ContraVarianceSample<BiCycle>()

    //invariance
    val number2 : List<Number> = listOf<Int>()
}

private fun <T>printAnimal(animal: T) {
    println(animal)
}