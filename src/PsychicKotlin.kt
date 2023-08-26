import java.lang.reflect.Field
import java.lang.reflect.Modifier
import kotlin.random.Random

val syncedGenerator: java.util.Random by lazy {
    // Get the java.util.Random used by kotlin.random.Random.Default and set the seed to a known value (0)
    Random::class.java.getDeclaredField("defaultRandom").let {
        it.isAccessible = true
        val defaultGenerator = it.get(kotlin.random.Random)

        defaultGenerator::class.java.getDeclaredMethod("getImpl").let {
            it.isAccessible = true
            (it.invoke(defaultGenerator) as java.util.Random).setSeed(0)
        }
    }

    // Return a generator with the same seed
    java.util.Random(0)
}

val rng = run {
    val fieldR = Random::class.java.getDeclaredField("defaultRandom")
    val fieldM = Field::class.java.getDeclaredField("modifiers")
    fieldM.isAccessible = true
    fieldR.isAccessible = true
    fieldM.setInt(fieldR, fieldR.modifiers and Modifier.FINAL.inv())
    fieldR.set(null, Random(10))
    Random(10)
}

fun main() {
    val random = Math.random()
    for (i in 1..5) {
        println(random == guess())
    }
}
var seed = 1
private fun predict() : Double {
    seed++

    val declaredField = Random::class.java.getDeclaredField("defaultRandom")
    declaredField.isAccessible = true
    declaredField.trySetAccessible()

    val modifiersField = Field::class.java.getDeclaredField("modifiers")
    modifiersField.isAccessible = true
    modifiersField.setInt(declaredField, declaredField.modifiers and Modifier.FINAL.inv())

    declaredField.set(null, Random(seed))

    return Random(seed).nextDouble()
}

private object PsychicKotlin {
    init {
        val field = Random::class.java.getDeclaredField("defaultRandom")
        field.isAccessible = true

        val modField = Field::class.java.getDeclaredField("modifiers")
        modField.isAccessible = true
        modField.setInt(field, field.modifiers.and(Modifier.FINAL.inv()))

        field.set(Random::class.java, Random(0))
    }

    val random = Random(0)
}

fun guess(): Double = PsychicKotlin.random.nextDouble()
